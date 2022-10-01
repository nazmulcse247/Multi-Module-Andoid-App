package com.example.data.repository

import com.example.common.utils.ApiResult
import com.example.data.mappers.BlogsApiMapper
import com.example.data.mappers.mapFromApiResponse
import com.example.data.mappers.toDomain
import com.example.data.network.utils.ApiService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.Blog
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val blogApiMapper: BlogsApiMapper,
    private val networkDebounce : SafeApiRequest
    ): BlogsRepository {

    //    override suspend fun getBlogs(): List<Blog> {
//
//        val response = safeApiRequest { apiService.getBlog() }
//
//        return response.data?.toDomain()?:emptyList()
//
//    }
    override suspend fun getBlogs(): Flow<ApiResult<Blogs>> {
        return mapFromApiResponse(
            networkDebounce.downloadData {
                apiService.getBlog()
            },blogApiMapper
        )
    }
}