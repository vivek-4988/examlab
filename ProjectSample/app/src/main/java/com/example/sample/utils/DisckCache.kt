package com.example.sample.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

object DiskCache {
    private const val CACHE_DIR_NAME = "image_cache"

    fun put(context:Context,url: String, bitmap: Bitmap) {
        val cacheDir = File(context.cacheDir, CACHE_DIR_NAME)
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
        val file = File(cacheDir, url.hashCode().toString())
        FileOutputStream(file).use { outputStream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        }
    }

    fun get(context:Context,url: String): Bitmap? {
        val cacheDir = File(context.cacheDir, CACHE_DIR_NAME)
        val file = File(cacheDir, url.hashCode().toString())
        if (file.exists()) {
            FileInputStream(file).use { inputStream ->
                return BitmapFactory.decodeStream(inputStream)
            }
        }
        return null
    }
}
