package com.vivek.zoodmall.data.repo

import com.vivek.zoodmall.data.api.Client

/*
* repo definations to attach with viewmodel
* */
object ZoodRepo {

    suspend fun getBanners() = Client.api.getBanners()

    suspend fun getProducts(page: Int) = Client.api.getProducts(page)

}