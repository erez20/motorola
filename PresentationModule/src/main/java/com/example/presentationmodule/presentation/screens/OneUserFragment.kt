package com.example.presentationmodule.presentation.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.presentationmodule.databinding.FragmentOneUserBinding
import com.example.presentationmodule.presentation.sharedViewModel.UsersSharedViewModel
import com.example.utilsmodule.utils.UsersDateUtils
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class OneUserFragment : Fragment() {

    private val dateUtils: UsersDateUtils by inject()

    private var _binding : FragmentOneUserBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by sharedViewModel<UsersSharedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.displayOneItem.observe(viewLifecycleOwner) {
            Log.e("xxxx", it.ageInMillis.toString())
            Glide.with(binding.image).load(it.picture).into(binding.image)
            binding.bdcount.text = dateUtils.countDownForNextBD(it.ageInMillis).toString()
            binding.userFullName.text = it.fullName
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOneUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = OneUserFragment()
    }
}