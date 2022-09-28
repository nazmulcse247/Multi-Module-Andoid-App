package com.example.domain.use_case

import com.example.common.utils.Resource
import com.example.domain.model.Blog
import com.example.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogUseCase @Inject constructor(private val blogsRepository: BlogsRepository) {

    operator fun invoke() : Flow<Resource<List<Blog>>> = flow {
        try {
            emit(Resource.Loading())

            val response = blogsRepository.getBlogs()
            emit(Resource.Success(response))
        }
        catch (e : Exception){
            emit(Resource.Error("Error Occoured"))

        }

    }
}