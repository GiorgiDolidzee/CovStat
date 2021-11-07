package com.example.midexam.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.midexam.MainActivity
import com.example.midexam.databinding.FragmentRegisterBinding
import com.example.midexam.fragments.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private lateinit var mAuth: FirebaseAuth

    override fun start() {
        registerService()
        loginInstead()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity() as? MainActivity
        activity?.hideToolBar()
    }

    private fun registerService() {
        mAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val rPassword = binding.etPasswordR.text.toString()
            android.util.Patterns.EMAIL_ADDRESS.matcher(email)

            if(email.isEmpty() && password.isEmpty() && rPassword.isEmpty()) {
                Toast.makeText(requireContext(), "აუცილებელია ყველა ველის შევსება \uD83D\uDE4C", Toast.LENGTH_SHORT).show()

            } else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(), "სწორად შეიყვანეთ E-mail \uD83D\uDC40", Toast.LENGTH_SHORT).show()

            } else if(password.length < 8) {
                Toast.makeText(requireContext(), "პაროლის სიგრძე უნდა აღემატებოდეს 8 სიმბოლოს \uD83D\uDC48", Toast.LENGTH_SHORT).show()

            } else if(password != rPassword) {
                Toast.makeText(requireContext(), "სწორად შეიყვანეთ ორივე პაროლი \uD83D\uDC50", Toast.LENGTH_SHORT).show()

            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            findNavController().popBackStack()
                            successSnackBar()
                        } else {
                            Toast.makeText(requireContext(), "მოხდა შეცდომა \uD83D\uDE36 სცადეთ თავიდან", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }

    private fun loginInstead() {
        binding.btnLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun successSnackBar() {
        val mySnackbar = Snackbar.make(requireView(),
            "თქვენ წარმატებით გაიარეთ რეგისტრაცია \uD83D\uDE0D", Snackbar.LENGTH_LONG)
        mySnackbar.show()
    }

}