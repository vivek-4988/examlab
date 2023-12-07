package com.vivek.zoodmall.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0017J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/vivek/zoodmall/ui/adapter/ProductAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/vivek/zoodmall/ui/adapter/ProductAdpater$ProductViewHolder;", "list", "", "Lcom/vivek/zoodmall/data/model/MarketListItem;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ProductViewHolder", "app_localDebug"})
public final class ProductAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.vivek.zoodmall.ui.adapter.ProductAdpater.ProductViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.vivek.zoodmall.data.model.MarketListItem> list = null;
    
    public ProductAdpater(@org.jetbrains.annotations.NotNull
    java.util.List<com.vivek.zoodmall.data.model.MarketListItem> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.vivek.zoodmall.data.model.MarketListItem> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.vivek.zoodmall.ui.adapter.ProductAdpater.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.vivek.zoodmall.ui.adapter.ProductAdpater.ProductViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/vivek/zoodmall/ui/adapter/ProductAdpater$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/vivek/zoodmall/databinding/ItemProductsBinding;", "(Lcom/vivek/zoodmall/databinding/ItemProductsBinding;)V", "getBinding", "()Lcom/vivek/zoodmall/databinding/ItemProductsBinding;", "bind", "", "item", "Lcom/vivek/zoodmall/data/model/MarketListItem;", "app_localDebug"})
    public static final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.vivek.zoodmall.databinding.ItemProductsBinding binding = null;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull
        com.vivek.zoodmall.databinding.ItemProductsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.vivek.zoodmall.databinding.ItemProductsBinding getBinding() {
            return null;
        }
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
        public final void bind(@org.jetbrains.annotations.NotNull
        com.vivek.zoodmall.data.model.MarketListItem item) {
        }
    }
}