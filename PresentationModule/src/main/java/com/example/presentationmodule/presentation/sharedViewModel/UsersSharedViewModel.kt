package com.example.presentationmodule.presentation.sharedViewModel

import androidx.lifecycle.*
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import com.example.presentationmodule.presentation.entities.asPresentationEntity
import com.example.utilsmodule.utils.UsersDateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsersSharedViewModel(
    private val userRepository: UserRepository,
    private val usersDateUtils: UsersDateUtils
) : ViewModel() {

    val presentationUsers =
        Transformations.map(userRepository.users) { userBusinessLogicEntityList: List<UserBusinessLogicEntity> ->
            userBusinessLogicEntityList.map { userBusinessLogicEntity ->
                userBusinessLogicEntity.asPresentationEntity(usersDateUtils)
            }.sortedBy { it.ageInMillis }
        }

    private val _displayOneItem = MutableLiveData<UserPresentationEntity>()
    val displayOneItem: LiveData<UserPresentationEntity>
        get() = _displayOneItem

    private val _displayProgressBar = MutableLiveData(false)
    val displayProgressBar: LiveData<Boolean>
        get() = _displayProgressBar

    private val _errorStatus = MutableLiveData("")
    val errorStatus: LiveData<String>
        get() = _errorStatus

    private val _eventNavigateToDetailed = MutableLiveData(false)
    val eventNavigateToDetailed: LiveData<Boolean>
        get() = _eventNavigateToDetailed


    fun itemSelected(userPresentationEntity: UserPresentationEntity) {
        _displayOneItem.value = userPresentationEntity
        onEventNavigateToDetailed()
    }

    fun refreshClicked() {
        displayNewUsers()
    }

    private fun displayNewUsers() {
        startProgressBar()
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    delay(5000L)
                    userRepository.initWithNewUsers(10).toString()

                }

            } catch (e: Exception) {
                updateErrorStatus("Error: ${e.message}")
            } finally {
                stopProgressBar()
            }
        }

    }

    private fun updateErrorStatus(message: String) {
        _errorStatus.value = message
    }

    public fun unsetErrorStatus() {
        _errorStatus.value = ""
    }


    private fun onEventNavigateToDetailed() {
        _eventNavigateToDetailed.value = true
    }

    fun onEventNavigateToDetailedCompleted() {
        _eventNavigateToDetailed.value = false
    }


    private fun stopProgressBar() {
        _displayProgressBar.postValue(false)
    }

    private fun startProgressBar() {
        _displayProgressBar.value = true
    }

    fun fetchNewUsers() {
        displayNewUsers()
    }

}