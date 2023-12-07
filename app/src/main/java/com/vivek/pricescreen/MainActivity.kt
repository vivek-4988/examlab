package com.vivek.pricescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.vivek.pricescreen.databinding.ActivityMainBinding
import com.vivek.pricescreen.model.MainDO
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


        println("Package ID: ${mainObj._id}")
        println("Package Name: ${mainObj.name}")
        println("Package Price: ${mainObj.price}")
    }
}