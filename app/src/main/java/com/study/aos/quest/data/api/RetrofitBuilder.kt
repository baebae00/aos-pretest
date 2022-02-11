package com.study.aos.quest.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://ghibliapi.herokuapp.com/"

    private val filmRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mainService: MainService = filmRetrofit.create(MainService::class.java)
}