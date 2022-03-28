package com.example.androidstudyguid.ui.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.fakes.CoroutinesTestRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
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
            .assertViewState(ArticleListViewState.success(testArticles))
    }
}