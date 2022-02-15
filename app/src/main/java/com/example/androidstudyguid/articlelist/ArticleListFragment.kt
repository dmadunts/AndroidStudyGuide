package com.example.androidstudyguid.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyguid.databinding.FragmentArticleListBinding
import com.example.androidstudyguid.models.Article

class ArticleListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentArticleListBinding.inflate(inflater, container, false)

        val adapter = ArticleAdapter()

        setupRecyclerView(binding.articleList, adapter)

        val articles = arrayListOf<Article>().apply {
            for (i in 1..10) {
                add(Article(i, "Title $i", "Author $i", "www.article$i.com"))
            }
        }
        adapter.submitList(articles)

        return binding.root
    }

    private fun <VH : RecyclerView.ViewHolder> setupRecyclerView(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<VH>
    ) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}
