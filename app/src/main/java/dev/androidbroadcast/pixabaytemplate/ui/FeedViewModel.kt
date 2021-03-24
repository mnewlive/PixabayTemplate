package dev.androidbroadcast.pixabaytemplate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.androidbroadcast.pixabaytemplate.api.data.SearchResponse
import dev.androidbroadcast.pixabaytemplate.repository.FeedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: FeedRepository
): ViewModel() {

    private val _response = MutableLiveData<SearchResponse>()
    val response: LiveData<SearchResponse> = _response

    fun search(query: String) {
        viewModelScope.launch {
            _response.value = repository.search(query = query)
        }
    }
}