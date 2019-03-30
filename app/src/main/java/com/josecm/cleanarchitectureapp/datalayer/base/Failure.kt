package com.josecm.cleanarchitectureapp.datalayer.base

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object Unknow: Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()
}