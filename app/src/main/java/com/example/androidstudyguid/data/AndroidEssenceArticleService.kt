package com.example.androidstudyguid.data

import com.example.androidstudyguid.data.remote.androidessence.AndroidEssenceAPI
import com.example.androidstudyguid.data.remote.androidessence.models.AndroidEssenceFeedItem
import com.example.androidstudyguid.models.Article
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class AndroidEssenceArticleService(
    private val dispatcher: CoroutineDispatcher = IO,
    private val api: AndroidEssenceAPI
) :
    ArticleRepository {
    override suspend fun fetchArticles(): List<Article> = withContext(dispatcher) {
        api.getFeed().items.map(AndroidEssenceFeedItem::toArticle)
    }
}

private fun AndroidEssenceFeedItem.toArticle(): Article {
    return Article(id = this.id, title = this.title, authorName = "", url = this.id)
}
