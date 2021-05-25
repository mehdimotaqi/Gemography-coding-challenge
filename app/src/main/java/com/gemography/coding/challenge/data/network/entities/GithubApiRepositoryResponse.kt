package com.gemography.coding.challenge.data.network.entities

data class RepositoryResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: RepositoryItem
)

data class RepositoryItem(
    val name: String,
    val owner: RepositoryOwner,
    val description: String
)

data class RepositoryOwner(
    val login: String,
    val avatar_url: String
)