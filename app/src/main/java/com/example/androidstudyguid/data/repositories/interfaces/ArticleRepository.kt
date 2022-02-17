package com.example.androidstudyguid.data.repositories.interfaces

import com.example.androidstudyguid.data.models.ui.Article

interface ArticleRepository {
    suspend fun fetchArticles(): List<Article>
}
