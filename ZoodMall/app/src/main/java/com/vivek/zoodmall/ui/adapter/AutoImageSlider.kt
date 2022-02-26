package com.vivek.zoodmall.ui.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.vivek.zoodmall.R


class AdapterImageSlider(private val act: Activity, items: List<String>) :
    PagerAdapter() {
    private var items: List<String>

    override fun getCount(): Int {
        return items.size
    }

    fun getItem(pos: Int): String {
        return items[pos]
    }

    fun setItems(items: List<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val o: String = items[position]
        val inflater = act.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.item_slider_layout, container, false)
        val image: ImageView = v.findViewById(R.id.image) as AppCompatImageView
        Glide.with(act).load(o).into(image)
        //Utils.displayImageOriginal(act, image, o.image)
//        lyt_parent.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//                if (onItemClickListener != null) {
//                    onItemClickListener!!.onItemClick(v, o)
//                }
//            }
//        })
        (container as ViewPager).addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as RelativeLayout)
    }

    // constructor
    init {
        this.items = items
    }
}