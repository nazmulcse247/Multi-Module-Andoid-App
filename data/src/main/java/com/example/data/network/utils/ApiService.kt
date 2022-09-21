package com.example.data.network.utils

import com.example.data.network.model.BlogDTO
import com.example.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("post")
    suspend fun getBlog() : Response<BlogsDTO>
}