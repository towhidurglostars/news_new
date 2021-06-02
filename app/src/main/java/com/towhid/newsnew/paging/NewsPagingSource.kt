package com.towhid.newsnew.paging

import androidx.paging.PagingSource
import com.towhid.newsnew.retrofit.response.Article

const val STARTING_INDEX = 1

class NewsPagingSource() : PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val position=params.key?: STARTING_INDEX

    }
}