package com.towhid.newsnew.adapter

import com.towhid.newsnew.retrofit.response.Article

interface AdapterClickListener {
    fun clickListener(article: Article)
}