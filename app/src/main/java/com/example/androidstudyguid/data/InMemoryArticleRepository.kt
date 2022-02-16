package com.example.androidstudyguid.data

import com.example.androidstudyguid.articlelist.ArticleListFragment
import com.example.androidstudyguid.models.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class InMemoryArticleRepository(private val dispatcher: CoroutineDispatcher = IO) :
    ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return withContext(dispatcher) {
            arrayListOf<Article>().apply {
                for (i in 1..ArticleListFragment.DEFAULT_ITEM_COUNT) {
                    add(
                        Article(
                            "$i",
                            "Title $i",
                            "Author $i",
                            "https://github.com/dmadunts/AndroidStudyGuide"
                        )
                    )
                }
            }
        }
    }
}
