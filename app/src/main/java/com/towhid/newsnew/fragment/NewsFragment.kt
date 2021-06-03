package com.towhid.newsnew.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.towhid.newsnew.NewsViewModel
import com.towhid.newsnew.R
import com.towhid.newsnew.adapter.AdapterClickListener
import com.towhid.newsnew.adapter.NewsPagingAdapter
import com.towhid.newsnew.retrofit.response.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news.view.*


@AndroidEntryPoint
class NewsFragment : Fragment(),AdapterClickListener {


    private val viewModel by viewModels<NewsViewModel>()

    private val newsPagingAdapter = NewsPagingAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.list.observe(viewLifecycleOwner) {
            newsPagingAdapter.submitData(lifecycle, it)
        }
        newsPagingAdapter.addLoadStateListener { state ->
            when (state.refresh) {
                is LoadState.Loading -> {
                    view.news_progress.visibility = View.VISIBLE
                }
                is LoadState.NotLoading -> {
                    view.news_progress.visibility=View.GONE
                }
                is LoadState.Error->{
                    view.news_progress.visibility=View.GONE
                    Toast.makeText(requireContext(),"Error occurs",Toast.LENGTH_SHORT).show()
                }

            }
        }
        view.news_recycler.adapter = newsPagingAdapter
    }

    override fun clickListener(article: Article) {
        findNavController().navigate(R.id.action_newsFragment_to_detailsFragment, bundleOf("article" to article))
    }


}