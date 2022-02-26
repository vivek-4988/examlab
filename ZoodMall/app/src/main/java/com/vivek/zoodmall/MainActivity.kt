package com.vivek.zoodmall

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.vivek.zoodmall.data.model.BannersResponseModel
import com.vivek.zoodmall.data.model.MarketListItem
import com.vivek.zoodmall.data.model.ProductsDo
import com.vivek.zoodmall.databinding.ActivityMainBinding
import com.vivek.zoodmall.ui.adapter.AdapterImageSlider
import com.vivek.zoodmall.ui.adapter.ProductAdpater
import com.vivek.zoodmall.ui.viewmodel.ZoodViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(ZoodViewModel::class.java)
    }

    //for auto image loading
    var runnable: Runnable? = null
    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.getBanners()
        vm.getProducts(1)
        vm.products.observe(this, Observer {
            val productsDo: ProductsDo = (it)
            val list = productsDo.Data?.marketList as List<MarketListItem>
            val myProductAdapter = ProductAdpater(list)
            binding.recycle.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = myProductAdapter
            }
            myProductAdapter.notifyDataSetChanged()
        })

        vm.banners.observe(this, Observer {
            val bannerResponseModel: BannersResponseModel = (it)
            val bin = bannerResponseModel.Data
            val listImages = arrayListOf<String>()

            for (item in bin?.mainBanner!!) {
                item?.imageUrl?.let { it1 -> listImages.add(it1) }
            }

            for (item in bin.brandZoneBanner!!) {
                item?.imageUrl?.let { it1 -> listImages.add(it1) }
            }

            for (item in bin.promotionalBanner!!) {
                item?.imageUrl?.let { it1 -> listImages.add(it1) }
            }

            for (item in bin.promotionalBanner2!!) {
                item?.imageUrl?.let { it1 -> listImages.add(it1) }
            }

            //getting all images
            val adapt = AdapterImageSlider(this, listImages)
            binding.bannerPager.apply {
                adapter = adapt
            }
            startAutoSlider(adapt.count)

        })
    }


    private fun startAutoSlider(count: Int) {
        handler = Handler()
        runnable = Runnable {
            var pos: Int = binding.bannerPager.getCurrentItem()
            pos += 1
            if (pos >= count) pos = 0
            binding.bannerPager.currentItem = pos
            handler!!.postDelayed(runnable!!, 3000)
        }
        handler!!.postDelayed(runnable!!, 3000)
    }

}