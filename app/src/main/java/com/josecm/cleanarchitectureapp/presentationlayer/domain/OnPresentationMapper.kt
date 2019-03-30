package com.josecm.cleanarchitectureapp.presentationlayer.domain

import com.josecm.cleanarchitectureapp.domainlayer.domain.CommentBO
import com.josecm.cleanarchitectureapp.domainlayer.domain.PostBO


fun boToVoComment(commentsBo: List<CommentBO>?): List<CommentVO>? {
    return commentsBo?.map {
        CommentVO(id = it.id,
            body = it.body,
            postId = it.postId)
    }
}

fun boToVoPost(postsBo: List<PostBO>?): List<PostVO>? {
    return postsBo?.map {
        PostVO(id = it.id,
            title = it.title,
            date = it.date)
    }
}