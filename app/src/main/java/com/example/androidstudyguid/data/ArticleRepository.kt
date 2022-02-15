package com.example.androidstudyguid.data

import com.example.androidstudyguid.models.Article

interface ArticleRepository {
    suspend fun fetchArticles(): List<Article>
}
