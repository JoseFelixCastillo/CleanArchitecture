package com.josecm.cleanarchitectureapp.domainlayer.domain

data class CommentBO(val id: Int?,
                     val body: String?,
                     val postId: Int?)

data class PostBO(val id: Int?,
                  val title: String?,
                  val date: String?)