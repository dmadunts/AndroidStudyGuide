package com.example.androidstudyguid.ui.articlelist

import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.fakes.FakesArticleRepository
import com.example.androidstudyguid.fakes.testObserver
import com.google.common.truth.Truth.assertThat

class ArticleListViewModelRobot {
    private lateinit var viewModel: ArticleListViewModel
    private val fakeRepository = FakesArticleRepository()

    fun mockArticles(articles: List<Article>) = apply {
        fakeRepository.setMockedArticles(articles)
    }

    fun buildViewModel() = apply {
        viewModel = ArticleListViewModel(fakeRepository)
    }

    fun assertViewState(expectedViewState: ArticleListViewState) = apply {
        val actualViewState = viewModel.state.testObserver().observedValue
        assertThat(actualViewState).isEqualTo(expectedViewState)
    }
}
