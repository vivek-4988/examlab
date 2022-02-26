package com.vivek.zoodmall.data.model

data class BannersResponseModel(
    val Message: String? = null,
    val Data: BannerResultData? = null,
    val ErrorCode: String? = null
)

data class BannerResultData(
    val mainBanner: List<MainBannerItem?>? = null,
    val promotionalBanner2: List<PromotionalBanner2Item?>? = null,
    val promotionalBanner: List<PromotionalBannerItem?>? = null,
    val brandZoneBanner: List<BrandZoneBannerItem?>? = null,
    val recommended: Recommended? = null
)

data class BrandZoneBannerItem(
    val imageUrl: String? = null,
    val id: Int? = null
)

data class Recommended(
    val productTagId: Int? = null,
    val name: String? = null
)

data class MainBannerItem(
    val imageUrl: String? = null,
    val id: Int? = null
)

data class PromotionalBannerItem(
    val imageUrl: String? = null,
    val id: Int? = null
)

data class PromotionalBanner2Item(
    val imageUrl: String? = null,
    val id: Int? = null
)


data class BannerItem(
    val imageUrl: String? = null,
    val id: Int? = null
)
