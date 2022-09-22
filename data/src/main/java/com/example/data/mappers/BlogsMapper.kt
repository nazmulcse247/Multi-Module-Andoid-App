package com.example.data.mappers

import com.example.data.network.model.BlogDTO
import com.example.data.network.model.OwnerDTO
import com.example.domain.model.Blog
import com.example.domain.model.Owner


fun List<BlogDTO>.toDomain() : List<Blog> {

    return map {
        Blog(
            id = it.id ?: "",
            image = it.image ?: "",
            publishDate = it.publishDate ?: "",
            text = it.text ?: "",
            owner = it.owner?.toDomain()?:Owner("" , "", "", "", "")
        )

    }
}

fun OwnerDTO.toDomain() : Owner{
    return Owner(
        firstName = this.firstName?: "",
        id = this.id?: "",
        lastName = this.lastName?: "",
        picture = this.picture?: "",
        title = this.title?: ""
    )
}
