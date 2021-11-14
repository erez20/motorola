package com.example.motorola.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motorola.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val usersSharedViewModel: UsersSharedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersSharedViewModel
    }
}