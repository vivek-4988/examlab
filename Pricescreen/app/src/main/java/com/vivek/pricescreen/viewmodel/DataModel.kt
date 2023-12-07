package com.vivek.pricescreen.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import java.io.IOException
import java.io.InputStream

class DataModel : ViewModel() {

    fun loadJSONFromAsset(context: Context, filename: String): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = context.assets.open(filename)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }




}