//package com.vivek.zoodmall.ui.adapter
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.vivek.zoodmall.data.api.ApiService
//import com.vivek.zoodmall.data.model.MarketData
//import com.vivek.zoodmall.data.model.MarketListItem
//import com.vivek.zoodmall.data.model.ProductsDo
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//
//class PagingSource(val intrface: ApiService) : PagingSource<Int, MarketListItem>() {
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarketListItem> {
//        val page = params.key ?: 1
//
//        return try {
//            val data = intrface.getProducts(page)
//
//            LoadResult.Page(
//                data = data.body()?.Data?.marketList!!,
//                prevKey = if (page == 1) null else -1,
//                nextKey = if (data.body()?.Data == null) null else page + 1)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, MarketListItem>): Int? {
//        return state.anchorPosition?.let {
//            val anchorPage = state?.closestPageToPosition(it)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}