package com.study.aos.quest.ui.main.rank

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.study.aos.quest.R
import com.study.aos.quest.data.response.ResponseFilmsDataItem
import com.study.aos.quest.databinding.FragmentRankBinding
import com.study.aos.quest.detail.FilmDetailActivity
import com.study.aos.quest.ui.base.BaseFragment
import com.study.aos.quest.ui.main.FilmListAdapter
import com.study.aos.quest.ui.viewmodel.MainViewModel

class RankFragment : BaseFragment<FragmentRankBinding>(R.layout.fragment_rank) {
    private val viewModel: MainViewModel by activityViewModels()
    private var filmList = emptyList<ResponseFilmsDataItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.requestFilmList()

        setRankFilmListAdapter()
        setViewModelObserver()

        return binding.root
    }

    private fun setRankFilmListAdapter(){
        val filmListAdapter = FilmListAdapter()

        filmListAdapter.setItemClickListener(object : FilmListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                // 클릭 시 이벤트 작성
                activity?.let{
                    val intent = Intent(requireContext(), FilmDetailActivity::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
                Toast.makeText(v.context, "클릭", Toast.LENGTH_SHORT).show()
            }
        })

        binding.rvRankList.adapter = filmListAdapter

        val decoration = DividerItemDecoration(requireContext(), LinearLayout.VERTICAL)
        binding.rvRankList.addItemDecoration(decoration)

    }

    private fun setViewModelObserver(){
        viewModel.filmList.observe(viewLifecycleOwner) {
                filmList -> with(binding.rvRankList.adapter as FilmListAdapter){
                setFilmList(filmList.sortedByDescending { it.rtScore.toInt()})
            }
        }
    }

}