package com.josecm.cleanarchitectureapp.domainlayer.repository

import com.josecm.cleanarchitectureapp.domainlayer.base.Either
import com.josecm.cleanarchitectureapp.datalayer.base.Failure
import com.josecm.cleanarchitectureapp.domainlayer.domain.CommentBO
import com.josecm.cleanarchitectureapp.domainlayer.domain.PostBO

interface CleanRepository {

    fun getPosts(): Either<Failure, List<PostBO>>
    fun getComments(): Either<Failure, List<CommentBO>>
}

