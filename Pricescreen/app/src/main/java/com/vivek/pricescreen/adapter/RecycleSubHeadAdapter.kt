package com.vivek.pricescreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vivek.pricescreen.databinding.RowItemCheckboxBinding
import com.vivek.pricescreen.databinding.RowItemRadioBinding
import com.vivek.pricescreen.model.SpecificationItem
import com.vivek.pricescreen.utils.ViewTypeEnum


class RecycleSubHeadAdapter(
    var con: Context,
    var list: ArrayList<SpecificationItem>,
    var type: Int
) : RecyclerView.Adapter<ViewHolder>() {

    var itemClick: ((String, SpecificationItem, Boolean) -> Unit)? = null

//    private lateinit var bindCheckBox: RowItemCheckboxBinding
//    private lateinit var bindRadio: RowItemRadioBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_CHECKBOX -> {
                val binding = RowItemCheckboxBinding.inflate(inflater, parent, false)
                CheckBoxViewHolder(binding)
            }

            VIEW_TYPE_RADIO -> {
                val binding = RowItemRadioBinding.inflate(inflater, parent, false)
                RadioBoxViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            var pos = holder.adapterPosition
            var myDo = list.get(pos)

            when (getItemViewType(pos)) {
                VIEW_TYPE_RADIO -> {
                    val holders = (holder as RadioBoxViewHolder?)!!
                    holders.bind(myDo)
                }

                VIEW_TYPE_CHECKBOX -> {
                    val holders = (holder as CheckBoxViewHolder?)!!
                    holders.bind(myDo)
                }
            }

//            bindCheckBox.checkSelect.
//
//            holder.itemView.setOnClickListener {
//                itemClick?.invoke(myDo._id, myDo)
//            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (ViewTypeEnum.VIEW_TYPE_RADIO.index == type) {
            return VIEW_TYPE_RADIO
        } else {
            return VIEW_TYPE_CHECKBOX
        }
    }

    inner class CheckBoxViewHolder(val binding: RowItemCheckboxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.checkSelect.setOnCheckedChangeListener { _, isChecked ->
                itemClick?.invoke(list[adapterPosition]._id, list[adapterPosition], isChecked)
            }
        }

        fun bind(data: SpecificationItem) {
            binding.checkSelect.text = data.name[0]
            val price = data.price
            if (price != 0) {
                binding.price.text = price.toString()
            }
        }
    }


    inner class RadioBoxViewHolder(val binding: RowItemRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.radioSelect.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Update the selection state
                    list.forEachIndexed { index, item ->
                        item.isSelected = index == position
                    }
                    notifyDataSetChanged()

                    // Invoke itemClick with isSelected = true
                    itemClick?.invoke(list[position]._id, list[position], true)
                }
            }
        }

        fun bind(data: SpecificationItem) {
            binding.radioSelect.text = data.name[0]
            val price = data.price
            if (price != 0) {
                binding.price.text = price.toString()
            }
        }
    }


    companion object {
        private const val VIEW_TYPE_RADIO = 1
        private const val VIEW_TYPE_CHECKBOX = 2
    }

}