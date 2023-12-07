package com.vivek.zoodmall.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\t\u001a\u0004\u0018\u00010\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ+\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/vivek/zoodmall/ui/adapter/PagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/vivek/zoodmall/data/model/MarketListItem;", "intrface", "Lcom/vivek/zoodmall/data/api/ApiService;", "(Lcom/vivek/zoodmall/data/api/ApiService;)V", "getIntrface", "()Lcom/vivek/zoodmall/data/api/ApiService;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_localDebug"})
public final class PagingSource extends androidx.paging.PagingSource<java.lang.Integer, com.vivek.zoodmall.data.model.MarketListItem> {
    @org.jetbrains.annotations.NotNull
    private final com.vivek.zoodmall.data.api.ApiService intrface = null;
    
    public PagingSource(@org.jetbrains.annotations.NotNull
    com.vivek.zoodmall.data.api.ApiService intrface) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vivek.zoodmall.data.api.ApiService getIntrface() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    androidx.paging.PagingSource.LoadParams<java.lang.Integer> params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, com.vivek.zoodmall.data.model.MarketListItem>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Integer getRefreshKey(@org.jetbrains.annotations.NotNull
    androidx.paging.PagingState<java.lang.Integer, com.vivek.zoodmall.data.model.MarketListItem> state) {
        return null;
    }
}