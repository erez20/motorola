package com.example.presentationmodule.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentationmodule.R
import com.example.presentationmodule.databinding.FragmentUserListBinding
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserListFragment : Fragment() {

    private var _binding : FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by sharedViewModel<UsersSharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = UsersRecyclerViewAdapter(::onItemSelected)
        binding.usersRecyclerView.adapter = rvAdapter
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(context)
        userViewModel.presentationUsers.observe(viewLifecycleOwner) {
            rvAdapter.updateList(it)
        }





    }

    private fun onItemSelected(userPresentationEntity: UserPresentationEntity) {
        userViewModel.itemSelected(userPresentationEntity)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}