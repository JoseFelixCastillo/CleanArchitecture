package com.josecm.cleanarchitectureapp.datalayer.service

import com.josecm.cleanarchitectureapp.datalayer.domain.CommentDTO
import retrofit2.Call
import retrofit2.http.GET

interface CommentService {

    @GET("/AlbertoLF/RindusTest/master/RindusTest/res/json/Comment.json")
    fun getCommentsItems(): Call<List<CommentDTO>>
}