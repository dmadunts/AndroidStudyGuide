package com.example.androidstudyguid.ui.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.utils.Result
import com.example.androidstudyguid.fakes.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticleListViewModelTest {
    private val testRobot = ArticleListViewModelRobot()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun successfulRequest() {
        val testArticles = listOf(
            Article("1", "title", "author", "url")
        )

        testRobot
            .mockArticles(testArticles)
            .buildViewModel()
            .assertViewState(Result.Success(testArticles))
    }
}
