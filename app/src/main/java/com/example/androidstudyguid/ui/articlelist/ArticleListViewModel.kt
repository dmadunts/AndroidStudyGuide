package com.example.androidstudyguid.ui.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.repositories.interfaces.ArticleRepository
import kotlinx.coroutines.launch

class ArticleListViewModel(articleRepository: ArticleRepository) : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        viewModelScope.launch {
            _articles.value = articleRepository.fetchArticles()
        }
    }
}
