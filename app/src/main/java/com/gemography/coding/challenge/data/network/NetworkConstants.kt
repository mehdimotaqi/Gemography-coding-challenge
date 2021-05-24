package com.gemography.coding.challenge.data.network

object NetworkConstant {
    const val NETWORK_TIMEOUT = 603333L
    const val NETWORK_BASE_URL = "https://api.github.com/"
}

object GithubApiUrlConstant{
    const val GET_REPOSITORIES = "repositories?"
}

object QueriesGithubApiConstant{
    const val Q = "q"
    const val SORT = "sort"
    const val ORDER = "order"
    const val PAGE = "page"
}

object GithubApiConstantQueriesValue{
    const val SORT_BY_STARTS = "stars"
    const val ORDER_BY_DESC = "desc"
}