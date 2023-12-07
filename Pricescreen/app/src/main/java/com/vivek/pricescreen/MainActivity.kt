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
import com.vivek.pricescreen.viewmodel.DataModel

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(DataModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val json = vm.loadJSONFromAsset(this@MainActivity, "item_data.json")
        val gson = Gson()
        val mainObj = gson.fromJson(json, MainDO::class.java)

        binding.packName.text = mainObj.name.get(0)

        val firstSelected = mainObj.specifications.get(0).list.get(0)._id
        val myList = filteredList(firstSelected, mainObj.specifications)
        showReycle(firstSelected, myList, mainObj.specifications)

        buttonAmount(mainObj.specifications.get(0).list.get(0).price)
    }


    fun buttonAmount(amount: Int) {
        binding.total.text = "Add To Cart ${amount}"
    }

    fun showReycle(
        firstSelected: String,
        myList: ArrayList<Specification>,
        specifications: List<Specification>
    ) {
        binding.recycle.apply {
            adapter = RecycleHeadAdapter(
                this@MainActivity,
                myList
            ).apply {
                subItemClick = {
                    val myList = filteredList(it, specifications)
                    showReycle(it, myList, specifications)
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