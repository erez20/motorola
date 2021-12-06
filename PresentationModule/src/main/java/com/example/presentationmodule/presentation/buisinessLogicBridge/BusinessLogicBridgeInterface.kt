package com.example.presentationmodule.presentation.buisinessLogicBridge

import androidx.lifecycle.LiveData
import com.example.presentationmodule.presentation.entities.UserPresentationEntity

interface BusinessLogicBridgeInterface {
    val users: LiveData<List<UserPresentationEntity>>

    suspend fun refreshUsers(amount: Int)
    suspend fun initUsers(amount: Int)
}
