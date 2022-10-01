package com.example.data.mappers

import com.example.data.network.model.BlogsDTO
import com.example.domain.model.Blog
import com.example.domain.model.Blogs
import com.example.domain.model.Owner
import javax.inject.Inject

class BlogsApiMapper @Inject constructor() : Mapper<BlogsDTO, Blogs> {
    override fun mapFromApiResponse(type: BlogsDTO): Blogs {
        return Blogs(
            limit = type.limit ?: 0,
            page = type.page ?: 0,
            total = type.total ?: 0,
            data = type.data?.map {
                Blog(
                    id = it.id ?: "-1",
                    image = it.image ?: "",
                    publishDate = it.image ?: "",
                    text = it.image ?: "",
                    owner = Owner(
                        firstName = it.owner?.firstName ?: "",
                        lastName = it.owner?.lastName ?: "",
                        id = it.owner?.id ?: "",
                        picture = it.owner?.picture ?: "",
                        title = it.owner?.title ?: "",
                    ),
                )
            } ?: listOf()
        )
    }
}