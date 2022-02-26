package com.vivek.zoodmall.data.api

import com.vivek.zoodmall.data.model.BannersResponseModel
import com.vivek.zoodmall.data.model.ProductsDo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("home?marketCode=UZ")
    suspend fun getBanners(): Response<BannersResponseModel>

    @GET("productlist?page=1&productTagId=13&marketCode=UZ")
    suspend fun getProducts(
        @Query("page") page: Int,
        @Query("productTagId") productTagId: Int = 13,
        @Query("marketCode") marketCode: String = "UZ"
    ): Response<ProductsDo>
}
