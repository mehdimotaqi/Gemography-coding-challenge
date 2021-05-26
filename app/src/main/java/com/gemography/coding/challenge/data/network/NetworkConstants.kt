package com.gemography.coding.challenge.data.network

object NetworkConstant {
    const val NETWORK_TIMEOUT = 603333L
    const val ERROR_MESSAGE = "Cannot proceed your request, please try again later"
    const val OFFLINE_MESSAGE = "No connection, turn your connection active to process"
    const val INCOMPLETE_RESULTS_ERROR = "Something wrong happened, please retry later"
    const val NETWORK_BASE_URL = "https://api.github.com/"
}

object GithubApiUrlConstant{
    const val GET_REPOSITORIES = "search/repositories?"
}

object QueriesGithubApiConstant{
    const val Q = "q"
    const val SORT = "sort"
    const val ORDER = "order"
    const val PAGE = "page"
}

object ConstantQueriesValue{
    const val SORT_BY_STARTS = "stars"
    const val ORDER_BY_DESC = "desc"
}