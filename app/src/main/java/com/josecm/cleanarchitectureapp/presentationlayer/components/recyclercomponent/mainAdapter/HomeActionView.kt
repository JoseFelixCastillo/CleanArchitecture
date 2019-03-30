package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter

import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base.ActionView

sealed class HomeActionView: ActionView() {
    object None: HomeActionView()
}