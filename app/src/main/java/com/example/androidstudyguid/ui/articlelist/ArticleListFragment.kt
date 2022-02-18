package com.example.androidstudyguid.ui.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyguid.data.apis.AndroidEssenceAPI
import com.example.androidstudyguid.data.models.ui.Article
import com.example.androidstudyguid.data.repositories.implementations.AndroidEssenceArticleService
import com.example.androidstudyguid.databinding.FragmentArticleListBinding
import com.example.androidstudyguid.utils.visibleIf
import kotlinx.coroutines.launch

class ArticleListFragment : Fragment() {
    private val viewModel: ArticleListViewModel by viewModels {
        articleViewModelFactory
    }
    private lateinit var adapter: ArticleAdapter
    private var _binding: FragmentArticleListBinding? = null
    private val binding get() = _binding!!
    private val articleViewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return ArticleListViewModel(AndroidEssenceArticleService(api = AndroidEssenceAPI.getDefaultApi())) as T
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleListBinding.inflate(inflater, container, false)
        adapter = ArticleAdapter(object : ArticleAdapter.OnArticleClickListener {
            override fun onArticleClick(article: Article) {
                val uri = Uri.parse(article.id)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        })

        setupRecyclerView(binding.articleList, adapter)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            lifecycleScope.launch {
                binding.progressBar.visibleIf(state.isLoading)
                binding.articleList.visibleIf(state.isSuccess)
                adapter.submitList(state.articles)
            }
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val DEFAULT_ITEM_COUNT = 50
    }
}
