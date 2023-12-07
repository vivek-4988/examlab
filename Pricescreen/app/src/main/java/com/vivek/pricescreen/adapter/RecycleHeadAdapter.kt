package com.vivek.pricescreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vivek.pricescreen.databinding.RowItemHeadBinding
import com.vivek.pricescreen.model.Specification
import com.vivek.pricescreen.model.SpecificationItem


class RecycleHeadAdapter(
    var con: Context,
    var list: ArrayList<Specification>,
) : RecyclerView.Adapter<RecycleHeadAdapter.HomeViewHolder>() {

    private lateinit var binding: RowItemHeadBinding
    var subItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding =
            RowItemHeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        try {
            var myDo = list.get(position)
            holder.bind(myDo)

            //val myList = filteredList(myDo.list.get(position)._id,list)
            binding.subHeadRecycle.apply {
                adapter = RecycleSubHeadAdapter(
                    context,
                    myDo.list as ArrayList<SpecificationItem>, myDo.type
                ).apply {
                    itemClick = {
                        if (position == 0) {
                            Toast.makeText(con, "Head: ${it}", Toast.LENGTH_SHORT).show()
                            subItemClick?.invoke(it)
                        } else {

                        }
                    }
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
        private val binding: RowItemHeadBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Specification) {
            binding.headName.text = data.name.get(0)
        }
    }

}