package com.example.androidstudyguid.ui.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguid.data.repositories.interfaces.ArticleRepository
import kotlinx.coroutines.launch

class ArticleListViewModel(articleRepository: ArticleRepository) : ViewModel() {
    private val _state = MutableLiveData<ArticleListViewState>()
    val state: LiveData<ArticleListViewState> = _state

    init {
        viewModelScope.launch {
            _state.value = ArticleListViewState.loading()
            try {
                val articles = articleRepository.fetchArticles()
                _state.value = ArticleListViewState.success(articles)
            } catch (e: Exception) {
                _state.value = ArticleListViewState.error(e)
            }
        }
    }
}
