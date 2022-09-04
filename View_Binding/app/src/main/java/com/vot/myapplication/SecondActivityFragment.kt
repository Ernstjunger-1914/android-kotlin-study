package com.vot.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vot.myapplication.databinding.FragmentSecondActivityBinding

class SecondActivityFragment : Fragment() {

    private var _binding: FragmentSecondActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondActivityBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.fragmentTextView.text = "수정된 text"

        return view
    }

}