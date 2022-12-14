package com.example.data.network.di

import com.example.common.utils.Constant.BASE_URL
import com.example.data.network.utils.ApiService
import com.example.data.repository.BlogRepositoryImpl
import com.example.domain.repository.BlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideGetBlogRepository(apiService: ApiService) : BlogsRepository {
//        return BlogRepositoryImpl(apiService = apiService)
//    }


}