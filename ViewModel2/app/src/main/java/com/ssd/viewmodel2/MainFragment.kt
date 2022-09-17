package com.ssd.viewmodel2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ssd.viewmodel2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainFragmentViewModel: MainFragmentViewModel

    var countNumber = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(TAG, "onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView()")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        mainFragmentViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]

        binding.plusButton.setOnClickListener {
            mainFragmentViewModel.plus()
            binding.resultNumber.text = mainFragmentViewModel.getCount().toString()
        }

        binding.minusButton.setOnClickListener {
            mainFragmentViewModel.minus()
            binding.resultNumber.text = mainFragmentViewModel.getCount().toString()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume()")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.d(TAG, "onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()

        Log.d(TAG, "onDetach()")
    }

    companion object {
        const val TAG: String = "MainFragment"
    }

}