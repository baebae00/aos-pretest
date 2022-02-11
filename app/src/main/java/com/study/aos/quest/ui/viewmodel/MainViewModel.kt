package com.study.aos.quest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.aos.quest.data.api.RetrofitBuilder
import com.study.aos.quest.data.response.ResponseFilmsDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel : ViewModel() {
    
    private val _filmList = MutableLiveData<List<ResponseFilmsDataItem>>()
    val filmList: LiveData<List<ResponseFilmsDataItem>>
        get() = _filmList

    fun requestFilmList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _filmList.postValue(RetrofitBuilder.mainService.getFilmList())
        } catch (e: HttpException) {

        }
    }
}