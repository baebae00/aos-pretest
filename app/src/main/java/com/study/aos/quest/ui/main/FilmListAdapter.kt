package com.study.aos.quest.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.aos.quest.data.response.ResponseFilmsDataItem
import com.study.aos.quest.databinding.ItemFilmInfoBinding

class FilmListAdapter : RecyclerView.Adapter<FilmListAdapter.FilmViewHolder>() {

    private var filmList = emptyList<ResponseFilmsDataItem>()

    class FilmViewHolder(
        private val binding : ItemFilmInfoBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(filmsDataItem: ResponseFilmsDataItem){
            binding.filmData = filmsDataItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemFilmInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmList[position])

        // 리스트 내 항목 클릭 시 onClick() 호출
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = filmList.size

    fun setFilmList(filmList : List<ResponseFilmsDataItem>){
        this.filmList = filmList
        notifyDataSetChanged()
    }

    fun getFilmDataByPosition(position : Int): ResponseFilmsDataItem {
        return filmList[position]
    }

    // 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    // 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    // setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener
}
