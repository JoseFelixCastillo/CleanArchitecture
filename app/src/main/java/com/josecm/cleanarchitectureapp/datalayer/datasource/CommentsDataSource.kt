package com.josecm.cleanarchitectureapp.datalayer.datasource

import com.josecm.cleanarchitectureapp.datalayer.api.createCommentService
import com.josecm.cleanarchitectureapp.datalayer.base.ApiRetrofitDataSource
import com.josecm.cleanarchitectureapp.datalayer.domain.CommentDTO

class CommentsDataSource: ApiRetrofitDataSource<List<CommentDTO>>() {
    override fun request(): List<CommentDTO>? {
        return requestApi(createCommentService().getCommentsItems())
    }
}