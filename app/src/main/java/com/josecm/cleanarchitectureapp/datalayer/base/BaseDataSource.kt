package com.josecm.cleanarchitectureapp.datalayer.base

abstract class BaseDataSource<T> {
    abstract fun request(): T?
    var isSuccessful: Boolean = false
    var failure: Failure? = null
}