package com.example.androidstudyguid.data.repositories.implementations

import com.example.androidstudyguid.data.apis.AndroidEssenceAPI
import com.example.androidstudyguid.data.models.remote.AndroidEssenceFeedItem
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.repositories.interfaces.ArticleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class AndroidEssenceArticleService(
    private val dispatcher: CoroutineDispatcher = IO,
    private val api: AndroidEssenceAPI
) :
    ArticleRepository {
    override suspend fun fetchArticles(): List<Article> = withContext(dispatcher) {
        api.getFeed().items?.map(AndroidEssenceFeedItem::toArticle).orEmpty()
    }
}

/**
 *  TODO: If any of this networking values are null, we should throw an error so we're aware.
 *   but we're decided not to crash so we don't ruin the UX.
 */
private fun AndroidEssenceFeedItem.toArticle(): Article {
    return Article(
        id = this.id.orEmpty(),
        title = this.title.orEmpty(),
        authorName = this.author?.name.orEmpty(),
        url = this.link?.href.orEmpty()
    )
}
