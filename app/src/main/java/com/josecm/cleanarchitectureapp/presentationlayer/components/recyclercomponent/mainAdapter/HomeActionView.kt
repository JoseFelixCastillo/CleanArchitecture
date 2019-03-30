package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.ActionView
import com.josecm.cleanarchitectureapp.presentationlayer.domain.CommentVO
import com.josecm.cleanarchitectureapp.presentationlayer.domain.PostVO

sealed class HomeActionView: ActionView() {
    object None: HomeActionView()
    data class Post(val post: PostVO): HomeActionView()
    data class Comment(val comment: CommentVO): HomeActionView()
}