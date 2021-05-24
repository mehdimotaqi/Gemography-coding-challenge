package com.gemography.coding.challenge.di

import com.gemography.coding.challenge.data.network.repo.GithubApiRepository
import com.gemography.coding.challenge.data.network.repo.GithubApiRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { GithubApiRepositoryImpl(get()) as GithubApiRepository }
}