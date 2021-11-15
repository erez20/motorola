package com.example.presentationmodule.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentationmodule.databinding.FragmentUserListBinding
import com.example.presentationmodule.presentation.sharedViewModel.UsersSharedViewModel
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import com.example.presentationmodule.presentation.recyclerViewAdapter.UsersRecyclerViewAdapter
import com.example.utilsmodule.utils.ShareUtils
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserListFragment : Fragment() {

    private val shareUtils: ShareUtils by inject()

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by sharedViewModel<UsersSharedViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = UsersRecyclerViewAdapter(::onItemSelected, ::onItemLongSelected)
        bindingViews(rvAdapter)
        observeViewModel(rvAdapter)


    }

    private fun observeViewModel(rvAdapter: UsersRecyclerViewAdapter) {
        userViewModel.presentationUsers.observe(viewLifecycleOwner) { it ->
            rvAdapter.updateList(it)
        }
    }


    private fun bindingViews(rvAdapter: UsersRecyclerViewAdapter) {
        binding.usersRecyclerView.adapter = rvAdapter
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.refresh.setOnClickListener {
            userViewModel.refreshClicked()
        }
    }

    private fun onItemSelected(userPresentationEntity: UserPresentationEntity) {
        userViewModel.itemSelected(userPresentationEntity)
    }

    private fun onItemLongSelected(userPresentationEntity: UserPresentationEntity) {
        context?.let {
            shareUtils.shareByEmailToAddress(it, userPresentationEntity.email)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}