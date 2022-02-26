package com.vivek.zoodmall.ui.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun bindingImg(view:AppCompatImageView,url:String){
    Glide.with(view.context).load(url).into(view)
}