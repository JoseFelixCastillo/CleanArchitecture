package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import android.view.View
import com.josecm.cleanarchitectureapp.R
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.BaseViewTypeAdapter
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.BaseViewTypeHolder

class HomeAdapter(itemList: MutableList<HomeItem>?, callback: (HomeActionView) -> Unit): BaseViewTypeAdapter<HomeItem, BaseViewTypeHolder<HomeItem, HomeActionView>, HomeActionView>(itemList, callback) {
    override fun getHolder(viewType: Int, view: View): BaseViewTypeHolder<HomeItem, HomeActionView> {
        return when (viewType) {
            HomeItem.ViewType.TYPE_POST.type -> PostViewHolder(view)
            HomeItem.ViewType.TYPE_COMMENT.type -> CommentViewHolder(view)
            else -> CommentViewHolder(view) //Needs to create a empty holder
        }
    }

    override fun getLayoutResourceIdByViewType(viewType: Int): Int {
        return when (viewType) {
            HomeItem.ViewType.TYPE_COMMENT.type -> R.layout.comment_viewholder_layout
            HomeItem.ViewType.TYPE_POST.type -> R.layout.post_viewholder_layout
            else -> R.layout.comment_viewholder_layout //Needs to put a empty case
        }
    }
}
