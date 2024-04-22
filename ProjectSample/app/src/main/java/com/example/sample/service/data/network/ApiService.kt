package com.example.sample.service.data.network

import com.example.sample.service.data.APIModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface defining API endpoints related operations.
 */
interface ApiService {

    @GET("content/misc/media-coverages")
    suspend fun getData(
        @Query("limit") limit: Int
    ): Response<APIModel?>
}