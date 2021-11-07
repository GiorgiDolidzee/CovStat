package com.example.midexam.fragments

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.midexam.MainActivity
import com.example.midexam.R
import com.example.midexam.databinding.FragmentLoginBinding
import com.example.midexam.fragments.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var mAuth: FirebaseAuth

    override fun start() {
        val activity = requireActivity() as? MainActivity
        activity?.hideToolBar()
        listeners()
        loginService()
    }


    private fun listeners() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


    private fun loginService() {
        mAuth = FirebaseAuth.getInstance()
        val email = binding.etEmail.text
        val password = binding.etPassword.text

        binding.btnLogin.setOnClickListener {
            if (email != null && password!= null) {
                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(requireContext(), "აუცილებელია ყველა ველის შევსება \uD83D\uDC48", Toast.LENGTH_SHORT).show()
                } else {
                    mAuth.signInWithEmailAndPassword(email.toString(), password.toString())
                        .addOnCompleteListener {
                            if(it.isSuccessful) {
                                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                            } else {
                                Toast.makeText(requireContext(), "მოხდა შეცდომა \uD83D\uDE36 სცადეთ თავიდან", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }

    }

}