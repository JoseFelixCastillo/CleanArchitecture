package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.BaseViewTypeItem

sealed class HomeItem(viewType: Int): BaseViewTypeItem(viewType) {
    enum class ViewType(val type: Int){
        TYPE_POST(1),
        TYPE_COMMENT (2)
    }

    open class HomePostItem: HomeItem(ViewType.TYPE_POST.type)
    open class HomeCommentItem: HomeItem(ViewType.TYPE_COMMENT.type)
}