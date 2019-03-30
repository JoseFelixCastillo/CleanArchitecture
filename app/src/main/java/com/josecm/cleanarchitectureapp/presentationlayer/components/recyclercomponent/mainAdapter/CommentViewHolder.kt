package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.BaseViewTypeHolder
import com.josecm.cleanarchitectureapp.presentationlayer.domain.CommentVO
import kotlinx.android.synthetic.main.comment_viewholder_layout.view.*

class CommentViewHolder(view: View): BaseViewTypeHolder<HomeItem, HomeActionView>(view = view) {
    private val comment: TextView? by lazy { view.comment__tv__content }
    private val container: ViewGroup? by lazy { view.comment__container }

    override fun onBind(item: HomeItem, callback: (HomeActionView) -> Unit) {
        (item as? CommentVO)?.let {
            comment?.text = item.body
            container?.setOnClickListener {
                callback(HomeActionView.Comment(item))
            }
        }
    }

}