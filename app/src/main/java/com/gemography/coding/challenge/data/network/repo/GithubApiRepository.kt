package com.gemography.coding.challenge.data.network.repo

import com.gemography.coding.challenge.data.network.entities.ApiResponse
import com.gemography.coding.challenge.utils.Either
import io.reactivex.Observable

interface GithubApiRepository {
    fun getRepositories(
        q: String,
        sort: String,
        order: String,
        page: Int
    ): Either<Throwable, Observable<ApiResponse>>
}