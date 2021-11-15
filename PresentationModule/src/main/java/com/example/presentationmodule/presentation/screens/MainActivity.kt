package com.example.presentationmodule.presentation.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.presentationmodule.databinding.ActivityMainBinding
import com.example.presentationmodule.presentation.sharedViewModel.UsersSharedViewModel
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersSharedViewModel: UsersSharedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        observeViewModel()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, UserListFragment.newInstance())
                .commit()
        }

    }

    private fun observeViewModel() {
        observeFetchNewUsersOnFirstUse()
        observeNavigateToOneUserFragment()
        observeDisplayProgressBar()
        observeErrorStatus()
    }

    private fun observeErrorStatus() {
        usersSharedViewModel.errorStatus.observe(this) {
            if (it != "") {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                usersSharedViewModel.unsetErrorStatus()
            }
        }
    }

    private fun observeFetchNewUsersOnFirstUse() {
        usersSharedViewModel.presentationUsers.observe(
            this,
            object : Observer<List<UserPresentationEntity>> {
                override fun onChanged(t: List<UserPresentationEntity>?) {
                    if (t.isNullOrEmpty()) {
                        usersSharedViewModel.fetchNewUsers()
                    }
                    usersSharedViewModel.presentationUsers.removeObserver(this)
                }
            })
    }

    private fun observeNavigateToOneUserFragment() {
        usersSharedViewModel.eventNavigateToDetailed.observe(this) {
            if (it) {
                supportFragmentManager.beginTransaction().addToBackStack("OneUserFragment")
                    .replace(binding.fragmentContainer.id, OneUserFragment.newInstance()).commit()
                usersSharedViewModel.onEventNavigateToDetailedCompleted()
            }
        }
    }

    private fun observeDisplayProgressBar() {
        usersSharedViewModel.displayProgressBar.observe(this) { displayProgressBar ->
            when (displayProgressBar) {
                true -> binding.progressBar.visibility = View.VISIBLE
                false -> binding.progressBar.visibility = View.GONE
            }
        }
    }

}