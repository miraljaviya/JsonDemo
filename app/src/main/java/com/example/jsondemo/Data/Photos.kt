package com.example.jsondemo.Data

import com.squareup.moshi.Json

data class Photos(
    @Json(name="id")
    val id:Int?,
    @Json(name="albumId")
    val albumId:Int?,
    @Json(name="title")
    val title:String?,
    @Json(name= "url")
    val url:String?,
    @Json(name= "thumbnailUrl")
    val thumbnailUrl:String?
)
