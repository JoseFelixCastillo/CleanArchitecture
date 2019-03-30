package com.josecm.cleanarchitectureapp.presentationlayer.feature

import com.josecm.cleanarchitectureapp.datalayer.base.Failure
import com.josecm.cleanarchitectureapp.presentationlayer.domain.CommentVO
import com.josecm.cleanarchitectureapp.presentationlayer.domain.PostVO

sealed class MainState {
    class ShowComment(val comments: List<CommentVO>?): MainState()
    class ShowPost(val posts: List<PostVO>?): MainState()
    class ShowError(val failure: Failure) : MainState() //TODO this failure will be FeatureFailure
}