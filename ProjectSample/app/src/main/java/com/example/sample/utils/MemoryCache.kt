package com.example.sample.utils

import android.graphics.Bitmap

object MemoryCache {
    private val cache = HashMap<String, Bitmap>()

    fun put(url: String, bitmap: Bitmap) {
        cache[url] = bitmap
    }

    fun get(url: String): Bitmap? {
        return cache[url]
    }
}
