package com.gemography.coding.challenge.data.network

import com.gemography.coding.challenge.data.network.entities.ApiResponse
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET(GithubApiUrlConstant.GET_REPOSITORIES)
    fun getRepositories(
        @Query(QueriesGithubApiConstant.Q) q: String,
        @Query(QueriesGithubApiConstant.SORT) sort: String,
        @Query(QueriesGithubApiConstant.ORDER) order: String,
        @Query(QueriesGithubApiConstant.PAGE) page: Int
    ): Observable<ApiResponse>

}