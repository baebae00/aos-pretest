package com.study.aos.quest.data.api

import com.study.aos.quest.data.response.ResponseFilmsDataItem
import retrofit2.http.GET

interface MainService {

    @GET("films")
    suspend fun getFilmList(): List<ResponseFilmsDataItem>

 }