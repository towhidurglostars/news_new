package com.towhid.newsnew.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.towhid.newsnew.R
import com.towhid.newsnew.databinding.FragmentDetailsBinding
import com.towhid.newsnew.retrofit.response.Article

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val data = requireArguments()["article"] as Article
        binding.article = data
        Glide.with(binding.root).load(data.urlToImage). into(binding.detailsIamge)
        return binding.root
    }


}