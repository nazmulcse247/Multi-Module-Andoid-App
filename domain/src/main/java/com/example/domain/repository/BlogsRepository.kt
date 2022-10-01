package com.example.domain.repository

import com.example.common.utils.ApiResult
import com.example.domain.model.Blog
import com.example.domain.model.Blogs
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface BlogsRepository {

    suspend fun getBlogs() : Flow<ApiResult<Blogs>>
}