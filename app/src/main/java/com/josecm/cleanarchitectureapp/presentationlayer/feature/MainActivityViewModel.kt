package com.josecm.cleanarchitectureapp.presentationlayer.feature

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.josecm.cleanarchitectureapp.datalayer.base.Failure
import com.josecm.cleanarchitectureapp.domainlayer.base.UseCase
import com.josecm.cleanarchitectureapp.domainlayer.domain.CommentBO
import com.josecm.cleanarchitectureapp.domainlayer.domain.PostBO
import com.josecm.cleanarchitectureapp.domainlayer.usecase.GetCommentApiUC
import com.josecm.cleanarchitectureapp.domainlayer.usecase.GetPostApiUC
import com.josecm.cleanarchitectureapp.presentationlayer.base.BaseViewModel
import com.josecm.cleanarchitectureapp.presentationlayer.base.ScreenState
import com.josecm.cleanarchitectureapp.presentationlayer.domain.boToVoComment
import com.josecm.cleanarchitectureapp.presentationlayer.domain.boToVoPost

class MainActivityViewModel: BaseViewModel() {

    private lateinit var _mainState: MutableLiveData<ScreenState<MainState>>
    private var getPostApiUC = GetPostApiUC() //TODO needs to be injected
    private var getCommentApiUC = GetCommentApiUC() //TODO needs to be injected


    val mainState: LiveData<ScreenState<MainState>>
        get() {
            if (!::_mainState.isInitialized) {
                _mainState = MutableLiveData()
                requestPost()    //Example for request when ui start
            }
            return _mainState
        }

    private fun handleComment(comments: List<CommentBO>) {
        _mainState.value = ScreenState.Render(MainState.ShowComment(comments = boToVoComment(comments)))
    }

    private fun handlePost(posts: List<PostBO>) {
        _mainState.value = ScreenState.Render(MainState.ShowPost(posts = boToVoPost(posts)))
    }

    private fun handleFailure(failure: Failure){
        _mainState.value = ScreenState.Render(MainState.ShowError(failure))
    }

    fun requestPost() {
        _mainState.value = ScreenState.Loading
        getPostApiUC(scope = this@MainActivityViewModel, params = UseCase.None(), onResult = {it.either(::handleFailure, ::handlePost)})
    }

    fun requestComment() {
        _mainState.value = ScreenState.Loading
        getCommentApiUC(scope = this@MainActivityViewModel, params = UseCase.None(), onResult = {it.either(::handleFailure, ::handleComment)})
    }

}