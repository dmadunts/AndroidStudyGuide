package com.example.androidstudyguid.data.repositories.implementations

import com.example.androidstudyguid.data.models.remote.AndroidEssenceAuthor
import com.example.androidstudyguid.data.models.remote.AndroidEssenceFeed
import com.example.androidstudyguid.data.models.remote.AndroidEssenceFeedItem
import com.example.androidstudyguid.data.models.remote.AndroidEssenceLink
import com.example.androidstudyguid.data.models.ui.Article
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AndroidEssenceArticleServiceTest {
    private val testRobot = AndroidEssenceArticleServiceTestRobot()

    @Test
    fun fetchValidAccountList() = runTest {
        val mockedFeed = AndroidEssenceFeed(
            items = listOf(
                AndroidEssenceFeedItem(
                    title = "Test Title",
                    id = "Test Id",
                    author = AndroidEssenceAuthor("David Madunts"),
                    link = AndroidEssenceLink("Test Link")
                )
            )
        )

        val expectedArticles = listOf(
            Article(
                id = "Test Id",
                title = "Test Title",
                authorName = "David Madunts",
                url = "Test Link"
            )
        )

        testRobot
            .mockFeed(mockedFeed)
            .buildService()
            .assertFetchedArticles(expectedArticles)
    }
}
