package com.josecm.cleanarchitectureapp.datalayer.datasource

import com.josecm.cleanarchitectureapp.datalayer.api.createPostService
import com.josecm.cleanarchitectureapp.datalayer.base.ApiRetrofitDataSource
import com.josecm.cleanarchitectureapp.datalayer.domain.PostDTO

class PostsDataSource: ApiRetrofitDataSource<List<PostDTO>>() {
    override fun request(): List<PostDTO>? {
        return requestApi(createPostService().getPostItems())
     }
}