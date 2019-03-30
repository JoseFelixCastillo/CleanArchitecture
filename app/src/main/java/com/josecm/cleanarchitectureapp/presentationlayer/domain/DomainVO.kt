package com.josecm.cleanarchitectureapp.presentationlayer.domain

import com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.mainAdapter.HomeItem

data class CommentVO(val id: Int?,
                     val body: String?,
                     val postId: Int?): HomeItem.HomeCommentItem()

data class PostVO(val id: Int?,
                  val title: String?,
                  val date: String?): HomeItem.HomePostItem()