package com.josecm.cleanarchitectureapp.datalayer.base

import retrofit2.Call
import java.io.IOException

abstract class ApiRetrofitDataSource<T>: BaseDataSource<T>() {
    protected fun requestApi(call: Call<T>): T? {
        //TODO test if is network alive for
        return try {
            val response = call.execute()
            isSuccessful = response.isSuccessful
            if (!isSuccessful) {
                failure = Failure.ServerError
            }
            response.body()
        } catch (exception: IOException) {
            isSuccessful = false
            failure = Failure.ServerError
            null
        }
    }

}