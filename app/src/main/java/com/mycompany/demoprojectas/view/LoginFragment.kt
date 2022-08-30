package com.mycompany.demoprojectas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mycompany.demoprojectas.R
import com.mycompany.demoprojectas.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding=FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()
            ValidateLogin(email,password)
        }
    }

    private fun ValidateLogin(email: String, password: String) {
        if (email.isEmpty()){
            binding.etEmail.setError("Email cant be empty")
            binding.etEmail.requestFocus()
        }
        else if (password.isEmpty()){
            binding.etPassword.setError("Password cant be empty")
            binding.etPassword.requestFocus()
        }
        else if (password.length<6){
            binding.etPassword.setError("Password should be atleast six digit")
            binding.etPassword.requestFocus()
        }
        else
            Toast.makeText(requireContext(), "all fields are filled", Toast.LENGTH_SHORT).show()
    }
}