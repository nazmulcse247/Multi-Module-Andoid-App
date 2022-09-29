package com.example.data.network.utils

import com.example.common.utils.Constant.APP_ID
import com.example.data.network.model.BlogDTO
import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("post")
    suspend fun getBlog(
        @Header("app-id") appId:String= APP_ID
    ) : Response<BlogsDTO>
}