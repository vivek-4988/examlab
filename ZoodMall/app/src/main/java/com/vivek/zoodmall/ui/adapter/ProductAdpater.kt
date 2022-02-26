package com.vivek.zoodmall.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.vivek.zoodmall.data.model.MarketListItem
import com.vivek.zoodmall.databinding.ItemProductsBinding


class ProductAdpater(val list: List<MarketListItem>): RecyclerView.Adapter<ProductAdpater.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemProductsBinding) : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(item: MarketListItem) {
            with(binding) {
                binding.model = item
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductsBinding.inflate(inflater)
        return ProductViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }
}