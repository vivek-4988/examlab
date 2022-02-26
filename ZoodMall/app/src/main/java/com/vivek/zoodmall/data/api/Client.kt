package com.vivek.zoodmall.data.api

import com.vivek.zoodmall.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    //reference by https://docs.github.com/en/rest/reference/search#search-users

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_END_POINT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(ApiService::class.java)

}