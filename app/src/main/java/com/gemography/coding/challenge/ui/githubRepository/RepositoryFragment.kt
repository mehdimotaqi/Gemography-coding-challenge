package com.gemography.coding.challenge.ui.githubRepository

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.gemography.coding.challenge.R
import com.gemography.coding.challenge.data.network.ConstantQueriesValue
import com.gemography.coding.challenge.data.network.entities.ApiResponse
import com.gemography.coding.challenge.databinding.FragmentRepositoryBinding
import com.gemography.coding.challenge.utils.State
import com.gemography.coding.challenge.utils.observe
import org.koin.android.ext.android.inject

class RepositoryFragment : Fragment(R.layout.fragment_repository) {

    private val repositoryViewModel by inject<RepositoryViewModel>()
    private lateinit var binding: FragmentRepositoryBinding
    private val initPage = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRepositoryBinding.bind(view)
        repositoryViewModel.getRepositories(
                "created:>2020-10-22",
                ConstantQueriesValue.ORDER_BY_DESC,
                ConstantQueriesValue.SORT_BY_STARTS,
                initPage
        )
        observe(repositoryViewModel.repositoriesLiveDate, :: repositoriesList)
    }

    private fun repositoriesList(state: State<String, ApiResponse>){
        when(state){
            is State.Loading -> {
                Log.d("GITHUB", "repositoriesList: Loading...")
            }
            is State.Success -> {
                Log.d("GITHUB", "repositoriesList: ${state.value.incompleteResults}")
            }

            is State.Error -> {
                Log.d("GITHUB", "Error: ${state.message}")
            }
        }
    }
}