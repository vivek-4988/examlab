package com.example.sample.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sample.SampleMyApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


const val ZERO_STRING = "0"
const val EMPTY_STRING: String = ""
const val SPACE: String = " "
const val ZERO_DOUBLE: Double = 0.0
const val ZERO_FLOAT: Float = 0.0f
const val ZERO_INT: Int = 0

/**
 * Extension function to check if the string value is less than or equal to the provided number.
 */
fun String.shouldLessThenNumber(number: Int): Boolean {
    return this.toFloat() <= number
}

/**
 * Extension function to check if the string value is equal to ZERO_FLOAT.
 */
fun String.IsZERO(): Boolean {
    return this.toFloat() == ZERO_FLOAT
}

/**
 * Extension function to check if the string value is equal to ZERO_INT.
 */
fun String.IsZero(): Boolean {
    return this.toInt() == ZERO_INT
}

/**
 * Extension function to get the string value from Editable, returning an empty string if blank.
 */
fun Editable.getString(): String {
    return if (isBlank()) EMPTY_STRING else toString()
}

/**
 * Extension function to get a non-null or non-blank string value, returning an empty string if null or blank.
 */
fun String?.getDataString(): String {
    return if (isNullOrBlank()) EMPTY_STRING else this
}

/**
 * Extension function to lazily retrieve a ViewModel instance within an AppCompatActivity.
 */
inline fun <reified T : ViewModel> AppCompatActivity.lazyViewModel() = lazy {
    ViewModelProvider(this).get(T::class.java)
}

/**
 * Extension function to load an image into an AppCompatImageView using Glide with progress indicator.
 */
fun AppCompatImageView.loadImage(url: String, error: Int, placeHolder: Int, viewModelScope: LifecycleCoroutineScope) {
    if (!url.isNullOrBlank()) {
        // Check memory cache
        val memoryCacheBitmap = MemoryCache.get(url)
        if (memoryCacheBitmap != null) {
            setImageBitmap(memoryCacheBitmap)
            return
        }

        viewModelScope.launch {
            try {
                // Check disk cache
                val diskCacheBitmap = withContext(Dispatchers.IO) {
                    DiskCache.get(context, url)
                }

                if (diskCacheBitmap != null) {
                    // Store in memory cache
                    MemoryCache.put(url, diskCacheBitmap)
                    setImageBitmap(diskCacheBitmap)
                } else {
                    // Make network request if not in cache
                    val bitmap = withContext(Dispatchers.IO) {
                        loadBitmapFromUrl(url)
                    }

                    // Store in memory cache
                    MemoryCache.put(url, bitmap)

                    // Store in disk cache
                    withContext(Dispatchers.IO) {
                        DiskCache.put(context,url, bitmap)
                    }

                    // Set the bitmap to the ImageView
                    setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                // Handle errors, such as network issues or decoding issues
                setImageResource(error)
            }
        }
    } else {
        // If the URL is null or blank, set the placeholder image
        setImageResource(placeHolder)
    }
}

// Function to load bitmap from URL
private fun loadBitmapFromUrl(urlString: String): Bitmap {
    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    connection.connectTimeout = 30000 // Set connection timeout
    connection.readTimeout = 30000 // Set read timeout
    connection.connect()

    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        val inputStream = connection.inputStream
        return BitmapFactory.decodeStream(inputStream)
    } else {
        // Handle HTTP error response
        throw IOException("HTTP error code: ${connection.responseCode}")
    }
}

// Function to decode bitmap from file
private fun decodeBitmap(file: File): Bitmap {
    val inputStream = FileInputStream(file)
    return BitmapFactory.decodeStream(inputStream)
}
/**
 * Extension function to set the visibility of a View based on a boolean value.
 */
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

/**
 * Extension function to check network availability using the application context.
 */
fun Context.isNetworkAvailable(): Boolean {
    return Utils.isNetworkAvailable(SampleMyApp.INSTANCE)
}


