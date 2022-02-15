package com.example.androidstudyguid.data

import com.example.androidstudyguid.articlelist.ArticleListFragment
import com.example.androidstudyguid.models.Article

class InMemoryArticleRepository : ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return arrayListOf<Article>().apply {
            for (i in 1..ArticleListFragment.DEFAULT_ITEM_COUNT) {
                add(
                    Article(
                        i,
                        "Title $i",
                        "Author $i",
                        "https://github.com/dmadunts/AndroidStudyGuide"
                    )
                )
            }
        }
    }
}
