package com.study.aos.quest.ui.main.star

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.study.aos.quest.R
import com.study.aos.quest.databinding.FragmentStarBinding
import com.study.aos.quest.ui.base.BaseFragment

class StarFragment :  BaseFragment<FragmentStarBinding>(R.layout.fragment_star) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }
}