package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base

/**
 * Item in adapter
 * @param viewTypeId viewType of item
 */
abstract class BaseViewTypeItem(val viewTypeId: Int = UNKNOWN) {
    companion object {
        const val UNKNOWN = -1
    }
}