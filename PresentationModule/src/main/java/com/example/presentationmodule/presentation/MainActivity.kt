package com.example.presentationmodule.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentationmodule.R
import com.example.presentationmodule.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val usersSharedViewModel: UsersSharedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usersSharedViewModel

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, UserListFragment.newInstance())
                .commit()
        }

    }
}