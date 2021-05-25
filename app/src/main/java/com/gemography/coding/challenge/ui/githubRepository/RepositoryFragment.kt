package com.gemography.coding.challenge.ui.githubRepository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gemography.coding.challenge.R
import org.koin.android.ext.android.inject

class RepositoryFragment : Fragment() {

    private val repositoryViewModel: RepositoryViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repository, container, false)
    }

}