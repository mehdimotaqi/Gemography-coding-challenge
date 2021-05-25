package com.gemography.coding.challenge.di

import com.gemography.coding.challenge.ui.githubRepository.RepositoryViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepositoryViewModel(get()) }
}