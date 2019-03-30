package com.josecm.cleanarchitectureapp.datalayer.api

import com.josecm.cleanarchitectureapp.datalayer.service.CommentService
import com.josecm.cleanarchitectureapp.datalayer.service.PostService

fun createCommentService(): CommentService {
    return ApiService.getInstance().create(CommentService::class.java)
}

fun createPostService(): PostService {
    return ApiService.getInstance().create(PostService::class.java)
}