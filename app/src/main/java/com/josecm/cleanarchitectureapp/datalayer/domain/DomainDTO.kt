package com.josecm.cleanarchitectureapp.datalayer.domain

data class CommentDTO(val id: Int?,
                      val body: String?,
                      val postId: Int?)

data class PostDTO(val id: Int?,
                  val title: String?,
                  val date: String?)