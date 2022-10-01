package com.example.data.network.di

import com.example.data.network.utils.ApiService
import com.example.data.repository.BlogRepositoryImpl
import com.example.domain.repository.BlogsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
interface BlogRepoModule {
    @Binds
    fun provideBlogRepo(repoImpl : BlogRepositoryImpl) : BlogsRepository
}