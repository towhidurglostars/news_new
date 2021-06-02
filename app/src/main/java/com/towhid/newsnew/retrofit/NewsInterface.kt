package com.towhid.newsnew.retrofit

import com.towhid.newsnew.retrofit.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("everything")
    suspend fun getAllNews(
        @Query("q") q: String = "tesla",
        @Query("from") from: String = "2021-05-02",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "22cb758dfac6464eb003c664b4602849",
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ):NewsResponse


}