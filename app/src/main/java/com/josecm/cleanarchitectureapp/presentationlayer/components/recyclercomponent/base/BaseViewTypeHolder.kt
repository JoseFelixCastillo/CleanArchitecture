package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base

import android.support.v7.widget.RecyclerView
import android.view.View


abstract class BaseViewTypeHolder<T: BaseViewTypeItem, A: ActionView>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun onBind(item: T, callback: (A) -> Unit)
}
