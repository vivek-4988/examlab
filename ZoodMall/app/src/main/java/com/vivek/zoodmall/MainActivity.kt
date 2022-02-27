package com.vivek.zoodmall

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.vivek.zoodmall.data.model.BannersResponseModel
import com.vivek.zoodmall.data.model.MarketListItem
import com.vivek.zoodmall.data.model.ProductsDo
import com.vivek.zoodmall.databinding.ActivityMainBinding
import com.vivek.zoodmall.ui.adapter.AdapterImageSlider
import com.vivek.zoodmall.ui.adapter.ProductAdpater
import com.vivek.zoodmall.ui.view.PaginationScrollListener
import com.vivek.zoodmall.ui.viewmodel.ZoodViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(ZoodViewModel::class.java)
    }

    //for auto image loading
    var runnable: Runnable? = null
    var handler: Handler? = null
    var currentPage: Int = 1

    var list = arrayListOf<MarketListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.getBanners()
        vm.getProducts(currentPage)
        var gridManager = GridLayoutManager(this, 2)
        binding.recycle.addOnScrollListener(object : PaginationScrollListener(gridManager) {
            override fun loadMoreItems() {
                currentPage++
                vm.getProducts(currentPage)
            }
        });

        vm.products.observe(this, Observer {
            val productsDo: ProductsDo = (it)
            val mlist = productsDo.Data?.marketList as List<MarketListItem>
            if (list?.isNotEmpty()) {
                list.addAll(mlist)
            } else {
                list = mlist as ArrayList<MarketListItem>;
            }
            val myProductAdapter = ProductAdpater(list)
            binding.recycle.apply {
                layoutManager = gridManager
                adapter = myProductAdapter
            }
            myProductAdapter.notifyItemChanged(list.size - 2)

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