package com.vivek.zoodmall.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J5\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/vivek/zoodmall/data/api/ApiService;", "", "getBanners", "Lretrofit2/Response;", "Lcom/vivek/zoodmall/data/model/BannersResponseModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProducts", "Lcom/vivek/zoodmall/data/model/ProductsDo;", "page", "", "productTagId", "marketCode", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_localDebug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "home?marketCode=UZ")
    public abstract java.lang.Object getBanners(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.vivek.zoodmall.data.model.BannersResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "productlist?page=1&productTagId=13&marketCode=UZ")
    public abstract java.lang.Object getProducts(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "productTagId")
    int productTagId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "marketCode")
    java.lang.String marketCode, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.vivek.zoodmall.data.model.ProductsDo>> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}