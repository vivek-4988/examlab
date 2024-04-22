package com.example.sample.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.example.gradlesample.R
import com.example.gradlesample.databinding.ItemCardBinding
import com.example.sample.service.data.APIModelItem
import com.example.sample.utils.loadImage

/**
 * RecyclerView Adapter class for displaying  items.
 * This adapter binds  data to the corresponding views.
 */
class GridImageAdapter(
    var list: ArrayList<APIModelItem>,
    var lifecycleScope: LifecycleCoroutineScope,
) : RecyclerView.Adapter<GridImageAdapter.ViewHolder>() {

    // Item click listener lambda
    var itemClick: ((APIModelItem, Int) -> Unit)? = null

    /**
     * Creates a new ViewHolder instance by inflating the item layout.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    /**
     * Binds data to the ViewHolder item views.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelObj = list[position]
        holder.bind(modelObj)

        // Set click listener for the item view
        holder.itemView.setOnClickListener {
            itemClick?.invoke(modelObj, position)
        }
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount() = list.size

    /**
     * Returns the view type of the item at the specified position.
     */
    override fun getItemViewType(position: Int): Int {
        return position
    }

    /**
     * Returns the stable item id that represents the given position.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * ViewHolder class for holding and binding  item views.
     */
    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds  data to the item views.
         */
        fun bind(data: APIModelItem) {
            try {
                binding.model = data
                binding.executePendingBindings()
                // Load  image using image loading library or method
                //imageURL = domain + "/" + basePath + "/0/" + key
                val imageURL = "${data.thumbnail.domain}/${data.thumbnail.basePath}/0/${data.thumbnail.key}"
                binding.img.loadImage(
                    imageURL,
                    error = android.R.drawable.stat_notify_error,
                    placeHolder = R.drawable.ic_launcher_background,
                    lifecycleScope
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}