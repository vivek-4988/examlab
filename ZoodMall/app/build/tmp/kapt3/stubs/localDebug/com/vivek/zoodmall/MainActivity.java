package com.vivek.zoodmall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\'\u001a\u0004\b$\u0010%\u00a8\u0006."}, d2 = {"Lcom/vivek/zoodmall/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/vivek/zoodmall/databinding/ActivityMainBinding;", "getBinding", "()Lcom/vivek/zoodmall/databinding/ActivityMainBinding;", "setBinding", "(Lcom/vivek/zoodmall/databinding/ActivityMainBinding;)V", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "list", "Ljava/util/ArrayList;", "Lcom/vivek/zoodmall/data/model/MarketListItem;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "vm", "Lcom/vivek/zoodmall/ui/viewmodel/ZoodViewModel;", "getVm", "()Lcom/vivek/zoodmall/ui/viewmodel/ZoodViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startAutoSlider", "count", "app_localDebug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.vivek.zoodmall.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy vm$delegate = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.Runnable runnable;
    @org.jetbrains.annotations.Nullable
    private android.os.Handler handler;
    private int currentPage = 1;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.vivek.zoodmall.data.model.MarketListItem> list;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vivek.zoodmall.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.vivek.zoodmall.databinding.ActivityMainBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.vivek.zoodmall.ui.viewmodel.ZoodViewModel getVm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    public final void setRunnable(@org.jetbrains.annotations.Nullable
    java.lang.Runnable p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.os.Handler getHandler() {
        return null;
    }
    
    public final void setHandler(@org.jetbrains.annotations.Nullable
    android.os.Handler p0) {
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    public final void setCurrentPage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.vivek.zoodmall.data.model.MarketListItem> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.vivek.zoodmall.data.model.MarketListItem> p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void startAutoSlider(int count) {
    }
}