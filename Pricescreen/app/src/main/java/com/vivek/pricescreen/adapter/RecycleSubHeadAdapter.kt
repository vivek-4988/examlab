package com.vivek.pricescreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vivek.pricescreen.databinding.RowItemSubheadBinding
import com.vivek.pricescreen.model.SpecificationItem


class RecycleSubHeadAdapter(
    var con: Context,
    var list: ArrayList<SpecificationItem>,
    var type: Int
) : RecyclerView.Adapter<RecycleSubHeadAdapter.HomeViewHolder>() {

    private lateinit var binding: RowItemSubheadBinding
    var itemClick: ((String) -> Unit)? = null

    private var selectedPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding =
            RowItemSubheadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        try {
            var myDo = list.get(position)
            holder.bind(myDo)
            binding.checkSelect.visibility = View.GONE
            binding.radioSelect.visibility = View.GONE

            if (type == 1) {
                binding.radioSelect.visibility = View.VISIBLE
                binding.checkSelect.visibility = View.GONE
                binding.radioSelect.isChecked = selectedPosition == position

                holder.itemView.setOnClickListener {
                    itemClick?.invoke(myDo._id)
                    selectedPosition = position
                    notifyDataSetChanged()
                }
            } else if (type == 2) {
                binding.radioSelect.visibility = View.GONE
                binding.checkSelect.visibility = View.VISIBLE
                binding.checkSelect.isChecked = myDo.isSelected

                holder.itemView.setOnClickListener {
                    myDo.isSelected = !myDo.isSelected
                    itemClick?.invoke(myDo._id)
                    notifyDataSetChanged()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class HomeViewHolder(
        private val binding: RowItemSubheadBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SpecificationItem) {
            binding.name.text = data.name.get(0)

            if (data.price != 0) {
                binding.price.text = "₹ ${data.price.toString()}"
            }

        }
    }
}