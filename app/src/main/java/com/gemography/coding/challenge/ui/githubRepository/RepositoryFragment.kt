package com.gemography.coding.challenge.ui.githubRepository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.gemography.coding.challenge.R
import com.gemography.coding.challenge.data.network.ConstantQueriesValue
import com.gemography.coding.challenge.data.network.entities.ApiResponse
import com.gemography.coding.challenge.databinding.FragmentRepositoryBinding
import com.gemography.coding.challenge.utils.State
import com.gemography.coding.challenge.utils.gone
import com.gemography.coding.challenge.utils.observe
import com.gemography.coding.challenge.utils.visible
import org.koin.android.ext.android.inject

class RepositoryFragment : Fragment(R.layout.fragment_repository) {

    private val repositoryViewModel by inject<RepositoryViewModel>()
    private lateinit var binding: FragmentRepositoryBinding
    private val initPage = 1

    private lateinit var adapter: RepositoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRepositoryBinding.bind(view)
        initObservers()
    }

    private fun initObservers() {
        repositoryViewModel.getRepositories(
                "created:>2020-10-22",
                ConstantQueriesValue.ORDER_BY_DESC,
                ConstantQueriesValue.SORT_BY_STARTS,
                initPage
        )
        observe(repositoryViewModel.repositoriesLiveDate, ::repositoriesList)
    }

    private fun repositoriesList(state: State<String, ApiResponse>){
        when(state){
            is State.Loading -> {
                binding.placeHolderLayout.visible()
            }
            is State.Success -> {
                binding.placeHolderLayout.gone()
                state.value.let {
                    if (!it.items.isNullOrEmpty()){
                        adapter = RepositoryAdapter(it.items)
                        binding.repoRecyclerView.adapter = adapter
                    }
                }
                binding.repoRecyclerView.visible()
            }
            is State.Error -> {
                Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}