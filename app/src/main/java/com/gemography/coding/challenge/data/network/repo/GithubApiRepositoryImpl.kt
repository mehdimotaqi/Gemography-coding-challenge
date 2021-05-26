package com.gemography.coding.challenge.data.network.repo

import com.gemography.coding.challenge.data.network.GithubApi
import com.gemography.coding.challenge.data.network.entities.ApiResponse
import com.gemography.coding.challenge.utils.Either
import com.gemography.coding.challenge.utils.runService
import io.reactivex.Observable

class GithubApiRepositoryImpl(
    private val githubApi: GithubApi
): GithubApiRepository {
    override fun getRepositories(
        q: String,
        sort: String,
        order: String,
        page: Int
    ): Either<Throwable, Observable<ApiResponse>> {
        return runService(githubApi.getRepositories(q, sort, order, page))
    }
}