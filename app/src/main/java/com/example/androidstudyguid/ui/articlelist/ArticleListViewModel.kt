package com.example.androidstudyguid.ui.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.repositories.interfaces.ArticleRepository
import com.example.androidstudyguid.data.utils.Result
import kotlinx.coroutines.launch

class ArticleListViewModel(private val articleRepository: ArticleRepository) : ViewModel() {
    private val _state = MutableLiveData<Result<List<Article>>>()
    val state: LiveData<Result<List<Article>>> = _state

    init {
        viewModelScope.launch {
            getArticles()
        }
    }

    suspend fun getArticles() {
        _state.value = Result.Loading
        try {
            val articles = articleRepository.fetchArticles()
            _state.value = Result.Success(articles)
        } catch (e: Exception) {
            _state.value = Result.Error(e)
        }
    }
}
