package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.BaseViewTypeHolder
import com.josecm.cleanarchitectureapp.presentationlayer.domain.PostVO
import kotlinx.android.synthetic.main.post_viewholder_layout.view.*

class PostViewHolder(view: View): BaseViewTypeHolder<HomeItem, HomeActionView>(view = view) {
    private val title: TextView? by lazy { view.post__tv__name }
    private val date: TextView? by lazy { view.post__tv__date_content }
    private val container: ViewGroup? by lazy { view.post__container }

    override fun onBind(item: HomeItem, callback: (HomeActionView) -> Unit) {
        (item as? PostVO)?.let {
            title?.text = item.title
            date?.text = item.date
            container?.setOnClickListener {
                callback(HomeActionView.Post(item))
            }
        }
    }
}