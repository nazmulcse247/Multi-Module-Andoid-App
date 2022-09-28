package com.example.domain.di

import com.example.domain.repository.BlogsRepository
import com.example.domain.use_case.GetBlogUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideBlogUseCase(blogsRepository: BlogsRepository) : GetBlogUseCase {
        return GetBlogUseCase(blogsRepository)
    }
}