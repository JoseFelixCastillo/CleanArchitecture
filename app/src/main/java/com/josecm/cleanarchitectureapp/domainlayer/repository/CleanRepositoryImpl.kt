package com.josecm.cleanarchitectureapp.domainlayer.repository

import com.josecm.cleanarchitectureapp.datalayer.datasource.CommentsDataSource
import com.josecm.cleanarchitectureapp.domainlayer.base.Either
import com.josecm.cleanarchitectureapp.datalayer.base.Failure
import com.josecm.cleanarchitectureapp.datalayer.datasource.PostsDataSource
import com.josecm.cleanarchitectureapp.domainlayer.domain.CommentBO
import com.josecm.cleanarchitectureapp.domainlayer.domain.PostBO
import com.josecm.cleanarchitectureapp.domainlayer.domain.dtoToBoComment
import com.josecm.cleanarchitectureapp.domainlayer.domain.dtoToBoPost

//TODO this class needs to be create singleton
class CleanRepositoryImpl: CleanRepository {

    //private val apiDataSource: ApiDataSource = ApiDataSourceImpl() //TODO needs to be injected
    private val commentDataSource = CommentsDataSource()
    private val postDataSource = PostsDataSource()
    override fun getPosts(): Either<Failure, List<PostBO>> {
        return postDataSource.request()?.let {
            if (postDataSource.isSuccessful) {
                Either.Right(dtoToBoPost(it) ?: emptyList())
            } else {
                Either.Left(postDataSource.failure ?: Failure.Unknow)
            }
        } ?: run {
            Either.Left(postDataSource.failure ?: Failure.Unknow)
        }
    }


    override fun getComments(): Either<Failure, List<CommentBO>> {
        return commentDataSource.request()?.let {
            if (commentDataSource.isSuccessful) {
                Either.Right(dtoToBoComment(it) ?: emptyList())
            } else {
                Either.Left(commentDataSource.failure ?: Failure.Unknow)
            }
        } ?: run {
            Either.Left(commentDataSource.failure ?: Failure.Unknow)
        }
    }

}