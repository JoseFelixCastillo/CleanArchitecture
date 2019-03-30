package com.josecm.cleanarchitectureapp.domainlayer.domain

import com.josecm.cleanarchitectureapp.datalayer.domain.CommentDTO
import com.josecm.cleanarchitectureapp.datalayer.domain.PostDTO

fun dtoToBoComment(commentsDTO: List<CommentDTO>?): List<CommentBO>? {
    return commentsDTO?.map {
        CommentBO(id = it.id,
            body = it.body,
            postId = it.postId)
    }
}

fun dtoToBoPost(postsDTO: List<PostDTO>?): List<PostBO>? {
    return postsDTO?.map {
        PostBO(id = it.id,
            title = it.title,
            date = it.date)
    }
}