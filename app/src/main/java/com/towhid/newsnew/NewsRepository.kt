package com.towhid.newsnew

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.towhid.newsnew.paging.NewsPagingSource
import com.towhid.newsnew.retrofit.NewsInterface
import com.towhid.newsnew.retrofit.response.Article

class NewsRepository(var newsInterface:NewsInterface) {

    fun getAllNewsStream(): LiveData<PagingData<Article>> = Pager(
    config = PagingConfig(
        pageSize = 20,
        prefetchDistance = 5,
        enablePlaceholders = false
    ),
        pagingSourceFactory = {
            NewsPagingSource(newsInterface)
        }
    ).liveData

}