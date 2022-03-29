package com.example.androidstudyguid.fakes

import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.repositories.interfaces.ArticleRepository

class FakesArticleRepository : ArticleRepository {
    private var mockedArticles: List<Article> = emptyList()
    private var fetchArticlesCallCount = 0

    override suspend fun fetchArticles(): List<Article> {
        fetchArticlesCallCount++
        return mockedArticles
    }

    fun setMockedArticles(articles: List<Article>) {
        this.mockedArticles = articles
    }

    fun getFetchedArticlesCallCount(): Int {
        return fetchArticlesCallCount
    }
}
