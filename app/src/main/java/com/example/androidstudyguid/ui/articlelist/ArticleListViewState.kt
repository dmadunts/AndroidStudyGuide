package com.example.androidstudyguid.ui.articlelist

import com.example.androidstudyguid.data.models.ui.Article

data class ArticleListViewState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val articles: List<Article> = emptyList(),
    val exception: Exception? = null
) {
    companion object {
        fun loading() = ArticleListViewState(isLoading = true)
        fun success(articles: List<Article>) =
            ArticleListViewState(isSuccess = true, articles = articles)

        fun error(e: Exception) = ArticleListViewState(isError = true, exception = e)
    }
}
