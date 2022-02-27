package com.vivek.zoodmall.ui.viewmodel

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.vivek.zoodmall.data.model.BannersResponseModel
import com.vivek.zoodmall.data.model.MarketData
import com.vivek.zoodmall.data.model.ProductsDo
import com.vivek.zoodmall.data.repo.ZoodRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
* ViewModel for MainActivity class api
* */
class ZoodViewModel : ViewModel() {

    val banners = MutableLiveData<BannersResponseModel>()
    val products = MutableLiveData<ProductsDo>()

    fun getBanners() {
        viewModelScope.launch {
            val res = withContext(Dispatchers.IO) { ZoodRepo.getBanners() }
            if (res.isSuccessful) {
                res.body()?.let {
                    //users.value = (it) // this only work in main thread
                    banners.postValue((it))
                }
            }
        }
    }

    fun getProducts(page: Int) {
        viewModelScope.launch {
            val res = withContext(Dispatchers.IO) { ZoodRepo.getProducts(page) }
            if (res.isSuccessful) {
                res.body()?.let {
                    //users.value = (it) // this only work in main thread
                    products.postValue((it))
                }
            }
        }
    }


}