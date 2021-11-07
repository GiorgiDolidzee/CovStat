package com.example.midexam.fragments.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.midexam.MainActivity
import com.example.midexam.R
import com.example.midexam.databinding.FragmentSplashScreenBinding
import com.example.midexam.fragments.base.BaseFragment
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {

    override fun start() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            splashScreen()
        }

    }

    private suspend fun splashScreen() {
        val time: Long = 2000
        delay(time)
        findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
    }

}