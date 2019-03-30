package com.josecm.cleanarchitectureapp.domainlayer.usecase

import com.josecm.cleanarchitectureapp.domainlayer.base.UseCase
import com.josecm.cleanarchitectureapp.domainlayer.domain.CommentBO
import com.josecm.cleanarchitectureapp.domainlayer.repository.CleanRepository
import com.josecm.cleanarchitectureapp.domainlayer.repository.CleanRepositoryImpl

class GetCommentApiUC : UseCase<List<CommentBO>, UseCase.None>() {
    private var repository: CleanRepository = CleanRepositoryImpl()  //TODO this need to be injected and clean repository needs to be singleton

    override suspend fun run(params: UseCase.None) = repository.getComments()
}