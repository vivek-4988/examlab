package com.vivek.zoodmall.databinding;
import com.vivek.zoodmall.R;
import com.vivek.zoodmall.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemProductsBindingImpl extends ItemProductsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView2;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemProductsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemProductsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            );
        this.imgLoad.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.vivek.zoodmall.data.model.MarketListItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.vivek.zoodmall.data.model.MarketListItem Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.vivek.zoodmall.data.model.MarketListItem model = mModel;
        java.lang.String modelName = null;
        java.lang.String modelImgUrl = null;
        java.lang.Integer modelLocalPrice = null;
        int androidxDatabindingViewDataBindingSafeUnboxModelLocalPrice = 0;
        java.lang.String stringValueOfModelLocalPrice = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.name
                    modelName = model.getName();
                    // read model.imgUrl
                    modelImgUrl = model.getImgUrl();
                    // read model.localPrice
                    modelLocalPrice = model.getLocalPrice();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(model.localPrice)
                androidxDatabindingViewDataBindingSafeUnboxModelLocalPrice = androidx.databinding.ViewDataBinding.safeUnbox(modelLocalPrice);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(model.localPrice))
                stringValueOfModelLocalPrice = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxModelLocalPrice);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.vivek.zoodmall.ui.adapter.CustomBindingKt.bindingImg(this.imgLoad, modelImgUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, modelName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfModelLocalPrice);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}