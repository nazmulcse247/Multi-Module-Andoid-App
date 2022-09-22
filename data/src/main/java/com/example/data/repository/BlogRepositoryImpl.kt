package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.utils.ApiService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.Blog
import com.example.domain.repository.BlogsRepository
import retrofit2.Response
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(private val apiService: ApiService): BlogsRepository , SafeApiRequest() {

    override suspend fun getBlogs(): List<Blog> {

        val response = safeApiRequest { apiService.getBlog() }

        return response.data?.toDomain()?:emptyList()

    }
}