package com.vivek.zoodmall.data.model


data class ProductsDo(
    val Message: String? = null,
    val Data: MarketData? = null,
    val ErrorCode: String? = null
)

data class MarketData(
    val Pagination: Pagination? = null,
    val marketList: List<MarketListItem?>? = null
)

data class MarketListItem(
    val imgUrl: String? = null,
    val ratingEmoji: String? = null,
    val productId: Int? = null,
    val name: String? = null,
    val rank: Int? = null,
    val localCrossedPrice: Int? = null,
    val brand: String? = null,
    val localPrice: Int? = null
)

data class Pagination(
    val totalPage: Int? = null,
    val page: Int? = null,
    val totalCount: Int? = null,
    val rowsPerPage: Int? = null
)
//
//@BindingAdapter("imageUrl")
//fun loadImage(view: AppCompatImageView, url: String) = Glide.with(view.context).load(url).into(view)
