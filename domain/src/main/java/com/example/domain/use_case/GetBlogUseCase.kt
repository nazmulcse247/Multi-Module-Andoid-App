package com.example.domain.use_case

import com.example.common.utils.ApiResult
import com.example.common.utils.Resource
import com.example.domain.model.Blog
import com.example.domain.model.Blogs
import com.example.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogUseCase @Inject constructor(private val blogsRepository: BlogsRepository) : ApiUseCaseNonParams<Blogs> {
    override suspend fun execute() = blogsRepository.getBlogs()
}