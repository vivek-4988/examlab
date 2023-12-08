package com.vivek.pricescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.vivek.pricescreen.adapter.RecycleHeadAdapter
import com.vivek.pricescreen.databinding.ActivityMainBinding
import com.vivek.pricescreen.model.MainDO
import com.vivek.pricescreen.model.Specification
import com.vivek.pricescreen.model.SpecificationItem
import com.vivek.pricescreen.viewmodel.DataModel

class PriceScreenActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(DataModel::class.java)
    }

    companion object {
        var totalAmount = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val json = vm.loadJSONFromAsset(this@PriceScreenActivity, "item_data.json")
        val gson = Gson()
        val parentObj = gson.fromJson(json, MainDO::class.java)

        binding.packName.text = parentObj.name.get(0)

        //first index of the json
        val firstSelected = parentObj.specifications.get(0).list.get(0)._id
        //filtering list for the json
        val myList = filteredList(firstSelected, parentObj.specifications)
        //filtered list will show in recycle
        showReycle(firstSelected, myList, parentObj.specifications)

        totalAmount = parentObj.specifications.get(0).list.get(0).price
        btnCartAmount(totalAmount)
    }


    //
    fun btnCartAmount(amount: Int) {
        binding.total.text = "Add To Cart ${amount}"
    }

    /*
    * list filtering and head recycle
    * */
    fun showReycle(
        firstSelected: String,
        myList: ArrayList<Specification>,
        specifications: List<Specification>
    ) {
        binding.recycle.apply {
            adapter = RecycleHeadAdapter(
                this@PriceScreenActivity,
                myList
            ).apply {
                subItemClick = { _id: String, specificationItem: SpecificationItem ->
                    val myList = filteredList(_id, specifications)
                    showReycle(_id, myList, specifications)
                    btnCartAmount(specificationItem.price)
                }

                updateItemClick =
                    { _id: String, specificationItem: SpecificationItem, isSelected: Boolean ->
                        if (isSelected) {
                            totalAmount += specificationItem.price
                            btnCartAmount(totalAmount)
                        } else {
                            totalAmount -= specificationItem.price
                            btnCartAmount(totalAmount)
                        }
                    }
            }
        }
    }

    fun filteredList(
        modifierId: String,
        specifications: List<Specification>
    ): ArrayList<Specification> {
        val filteredList = ArrayList<Specification>()
        filteredList.add(specifications.get(0))
        specifications.forEach {
            val obj = it
            if (obj.modifierId != null && obj.modifierId.equals(modifierId)) {
                filteredList.add(obj)
            }
        }
        return filteredList
    }
}