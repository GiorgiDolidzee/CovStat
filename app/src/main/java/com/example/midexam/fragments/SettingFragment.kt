package com.example.midexam.fragments


import com.example.midexam.databinding.FragmentSettingBinding
import com.example.midexam.fragments.base.BaseFragment


class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {

    override fun start() {
        listeners()
    }

    private fun listeners() {
        binding.btnExit.setOnClickListener {
//            findNavController().navigate()
        }
    }

}