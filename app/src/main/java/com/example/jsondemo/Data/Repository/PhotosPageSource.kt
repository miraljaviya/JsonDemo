package com.example.jsondemo.Data.Repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jsondemo.Data.Photos
import com.example.jsondemo.Data.Network.ApiService
import retrofit2.HttpException
import java.io.IOException

class PhotosPageSource constructor(private val apiService: ApiService) : PagingSource<Int,Photos>() {

    private val DEFAULT_PAGE_INDEX= 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photos> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = apiService.getAllPhotos(page,params.loadSize)
            LoadResult.Page(
                response,
                prevKey = if(page == DEFAULT_PAGE_INDEX) null else page-1,
                nextKey = if(response.isEmpty()) null else page+1
            )
        } catch (exception:IOException){
            LoadResult.Error(exception)
        } catch (exception:HttpException){
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photos>): Int? {
     return null
    }
}
