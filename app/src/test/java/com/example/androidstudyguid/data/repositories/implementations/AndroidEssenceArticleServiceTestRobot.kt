package com.example.androidstudyguid.data.repositories.implementations

import com.example.androidstudyguid.data.models.remote.AndroidEssenceFeed
import com.example.androidstudyguid.data.models.ui.Article
import com.google.common.truth.Truth.assertThat

class AndroidEssenceArticleServiceTestRobot {
    private val fakeApi = FakeAndroidEssenceAPI()
    private lateinit var service: AndroidEssenceArticleService

    fun buildService() = apply {
        this.service = AndroidEssenceArticleService(
            api = fakeApi
        )
    }

    fun mockFeed(feed: AndroidEssenceFeed) = apply {
        fakeApi.setMockedFeed(feed)
    }

    suspend fun assertFetchedArticles(expectedArticles: List<Article>) = apply {
        val actualArticles = service.fetchArticles()
        assertThat(expectedArticles).isEqualTo(actualArticles)
    }
}
