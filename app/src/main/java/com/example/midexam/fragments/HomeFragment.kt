package com.example.midexam.fragments

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.lifecycleScope
import com.example.midexam.MainActivity
import com.example.midexam.databinding.FragmentHomeBinding
import com.example.midexam.fragments.base.BaseFragment
import com.example.midexam.network.NetworkClient

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun start() {
        val activity = requireActivity() as? MainActivity
        activity?.showToolBar()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            retrofitService()
        }
        callEmergency()
    }


    private suspend fun retrofitService() {
        val api = NetworkClient.apiClient!!

        val response = api.getCovidInfo("Georgia")
        val body = response.body()!!
        if (response.isSuccessful) {
            binding.tvConfirmed.text = body.all?.confirmed.toString()
            binding.tvDeath.text = body.all?.deaths.toString()
            binding.tvRecovered.text = body.all?.recovered.toString()
            binding.tvUpdate.text = body.all?.updated.toString()
        }

    }


    private fun callEmergency() {
        val url = ""
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        intent.data = Uri.parse(url)

        binding.btnEmergency.setOnClickListener {
            startActivity(intent)
        }
    }


}