package com.towhid.newsnew.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.towhid.newsnew.Constants
import com.towhid.newsnew.retrofit.NewsInterface
import com.towhid.newsnew.retrofit.response.Article
import retrofit2.HttpException
import java.io.IOException

const val STARTING_INDEX = 1

class NewsPagingSource(var newsInterface: NewsInterface) : PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val position = params.key ?: STARTING_INDEX

        return try {
            var data =newsInterface.getAllNews("tesla","2021-05-02","publishedAt",Constants.API_KEY,position,params.loadSize)
            LoadResult.Page(
                data=data.articles,
                prevKey = if (params.key== STARTING_INDEX) null else position-1,
                nextKey = if (data.articles.isEmpty()) null else position+1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }


    }
}