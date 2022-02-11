package com.study.aos.quest.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.study.aos.quest.data.response.ResponseFilmsDataItem
import com.study.aos.quest.databinding.ActivityDetailBinding
import com.study.aos.quest.ui.viewmodel.MainViewModel

class FilmDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val filmDetailViewModel: MainViewModel by viewModels()
    private lateinit var id: String
    private lateinit var responseFilmData: ResponseFilmsDataItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        id = intent.getStringExtra("id")!!
        setFilmDetailData()
    }

    private fun setFilmDetailData() {
        // binding.btnFilmDetailBookmark.isChecked = filmDetailViewModel.getFilmBookmark(id)
        filmDetailViewModel.requestFilmList()
        filmDetailViewModel.filmList.observe(this, Observer { filmDetail ->
            binding.filmData = responseFilmData
            Glide.with(binding.ivFilmDetailImage.context)
                .load(responseFilmData.image)
                .into(binding.ivFilmDetailImage)
            //responseFilmData = ResponseFilmData(filmDetail.id, filmDetail.title, filmDetail.director, filmDetail.description, filmDetail.rtScore, filmDetail.image)
            //setFilmBookmarkClickListener(id, responseFilmData)


        })
    }
}