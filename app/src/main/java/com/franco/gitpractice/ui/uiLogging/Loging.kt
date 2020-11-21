package com.franco.gitpractice.ui.uiLogging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.franco.gitpractice.R
import com.franco.gitpractice.databinding.FragmentLogingBinding

class Loging : Fragment() {

    private lateinit var logingViewModel: LogingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        logingViewModel =
                ViewModelProvider(this).get(LogingViewModel::class.java)
        val binding = FragmentLogingBinding.inflate(layoutInflater)

        with(binding.textHome) {
            text = getString(R.string.workwithAndroid)
            textSize = 24f
        }

        binding.button1.setOnClickListener {
            binding.button1.text = "kotlin basic"
        }

        logingViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
        return binding.root
    }
}




