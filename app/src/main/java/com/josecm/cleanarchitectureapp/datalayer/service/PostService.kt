package com.josecm.cleanarchitectureapp.datalayer.service

import com.josecm.cleanarchitectureapp.datalayer.domain.PostDTO
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("/AlbertoLF/RindusTest/master/RindusTest/res/json/Post.json")
    fun getPostItems(): Call<List<PostDTO>>
}