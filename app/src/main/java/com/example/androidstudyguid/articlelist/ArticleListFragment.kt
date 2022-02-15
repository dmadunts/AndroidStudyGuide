package com.example.androidstudyguid.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyguid.data.InMemoryArticleRepository
import com.example.androidstudyguid.databinding.FragmentArticleListBinding
import com.example.androidstudyguid.models.Article
import kotlinx.coroutines.launch

class ArticleListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentArticleListBinding.inflate(inflater, container, false)
        val repository = InMemoryArticleRepository()
        val adapter = ArticleAdapter(object : ArticleAdapter.OnArticleClickListener {
            override fun onArticleClick(article: Article) {
                val uri = Uri.parse(article.url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        })

        setupRecyclerView(binding.articleList, adapter)

        lifecycleScope.launch {
            adapter.submitList(repository.fetchArticles())
        }

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

    companion object {
        const val DEFAULT_ITEM_COUNT = 50
    }
}
