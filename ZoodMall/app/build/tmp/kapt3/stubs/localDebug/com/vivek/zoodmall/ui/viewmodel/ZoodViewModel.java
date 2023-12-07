package com.vivek.zoodmall.ui.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u000bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/vivek/zoodmall/ui/viewmodel/ZoodViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "banners", "Landroidx/lifecycle/MutableLiveData;", "Lcom/vivek/zoodmall/data/model/BannersResponseModel;", "getBanners", "()Landroidx/lifecycle/MutableLiveData;", "products", "Lcom/vivek/zoodmall/data/model/ProductsDo;", "getProducts", "", "page", "", "app_localDebug"})
public final class ZoodViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.vivek.zoodmall.data.model.BannersResponseModel> banners = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.vivek.zoodmall.data.model.ProductsDo> products = null;
    
    public ZoodViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.vivek.zoodmall.data.model.BannersResponseModel> getBanners() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.vivek.zoodmall.data.model.ProductsDo> getProducts() {
        return null;
    }
    
    public final void getBanners() {
    }
    
    public final void getProducts(int page) {
    }
}