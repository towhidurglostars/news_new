package com.towhid.newsnew

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.towhid.newsnew.retrofit.response.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private var newsRepository: NewsRepository
) : ViewModel() {
    var list: LiveData<PagingData<Article>> = newsRepository.getAllNewsStream()
}