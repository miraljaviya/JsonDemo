package com.example.jsondemo.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jsondemo.Data.Photos
import com.example.jsondemo.Data.Network.ApiService
import com.example.jsondemo.Data.Repository.PhotosPageSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val apiService: ApiService) : ViewModel()
{
    val getAllPhotos:Flow<PagingData<Photos>> = Pager(config = PagingConfig(20,enablePlaceholders = false)){
        PhotosPageSource(apiService)
    }.flow.cachedIn(viewModelScope)


}
