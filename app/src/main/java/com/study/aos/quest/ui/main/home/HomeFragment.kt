package com.study.aos.quest.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.study.aos.quest.R
import com.study.aos.quest.databinding.FragmentHomeBinding
import com.study.aos.quest.ui.base.BaseFragment
import com.study.aos.quest.ui.base.BaseActivity
import com.study.aos.quest.ui.main.FilmListAdapter
import com.study.aos.quest.ui.viewmodel.MainViewModel

class HomeFragment :  BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.requestFilmList()

        setHomeFilmListAdapter()
        setViewModelObserver()

        return binding.root
    }

    private fun setHomeFilmListAdapter(){
        val filmListAdapter = FilmListAdapter()

        filmListAdapter.setItemClickListener(object : FilmListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val filmData = filmListAdapter.getFilmDataByPosition(position)
                val intent = Intent(requireContext(), BaseActivity::class.java)
                intent.putExtra("film", filmData)
                startActivity(intent)
            }
        })

        binding.rvHomeList.adapter = filmListAdapter

        val decoration = DividerItemDecoration(requireContext(), VERTICAL)
        binding.rvHomeList.addItemDecoration(decoration)

    }

    private fun setViewModelObserver(){
        viewModel.filmList.observe(viewLifecycleOwner) {
            filmList ->
            with(binding.rvHomeList.adapter as FilmListAdapter){
                setFilmList(filmList.sortedBy { it.title })
            }
        }
    }

}