package com.gemography.coding.challenge.ui.githubRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gemography.coding.challenge.data.network.NetworkConstant
import com.gemography.coding.challenge.data.network.entities.ApiResponse
import com.gemography.coding.challenge.data.network.repo.GithubApiRepository
import com.gemography.coding.challenge.utils.State
import com.gemography.coding.challenge.utils.getError
import com.gemography.coding.challenge.utils.value
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RepositoryViewModel(
    private val githubApiRepository: GithubApiRepository
) : ViewModel() {

    private var disposable: Disposable? = null
    private var _repositoriesLiveDate = MutableLiveData<State<String, ApiResponse>>()
    val repositoriesLiveDate: LiveData<State<String, ApiResponse>>
        get() = _repositoriesLiveDate

    fun getRepositories(q: String, sort: String, order: String, page: Int) {
        _repositoriesLiveDate.postValue(State.Loading)
        val result = githubApiRepository.getRepositories(q, sort, order, page)
        result.value()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ApiResponse> {
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(repositoryResponse: ApiResponse) {
                    if (repositoryResponse.incompleteResults!!) {
                        _repositoriesLiveDate.postValue(State.Success(repositoryResponse))
                    } else {
                        _repositoriesLiveDate.postValue(State.Error(NetworkConstant.INCOMPLETE_RESULTS_ERROR))
                    }
                }

                override fun onError(e: Throwable) {
                    _repositoriesLiveDate.postValue(State.Error(e.getError()))
                }

                override fun onComplete() {}

            })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}