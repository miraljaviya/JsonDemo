package com.example.jsondemo.Data.Network

import com.example.jsondemo.Data.Photos
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("photos")
    suspend fun getAllPhotos(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ):List<Photos>
}