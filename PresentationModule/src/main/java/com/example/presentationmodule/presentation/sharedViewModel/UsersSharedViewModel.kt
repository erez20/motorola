package com.example.presentationmodule.presentation.sharedViewModel

import androidx.lifecycle.*
import com.example.presentationmodule.presentation.buisinessLogicBridge.BusinessLogicBridgeInterface
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsersSharedViewModel(
    private val blBridge: BusinessLogicBridgeInterface
) : ViewModel() {


    val presentationUsers: LiveData<List<UserPresentationEntity>> =
        Transformations.map(blBridge.users) { it ->
            it.sortedBy {
                it.ageInMillis
            }
        }

    private val _displayOneItem = MutableLiveData<UserPresentationEntity>()
    val displayOneItem: LiveData<UserPresentationEntity>
        get() = _displayOneItem

    private val _displayProgressBar = MutableLiveData(false)
    val displayProgressBar: LiveData<Boolean>
        get() = _displayProgressBar

    private val _errorStatus: MutableLiveData<ErrorStatus> =
        MutableLiveData(ErrorStatus.NoErrorExits)
    val errorStatus: MutableLiveData<ErrorStatus>
        get() = _errorStatus

    private val _eventNavigateToDetailed = MutableLiveData(false)
    val eventNavigateToDetailed: LiveData<Boolean>
        get() = _eventNavigateToDetailed


    fun initNewUsers() {
        viewModelScope.launch {
            try {
                startProgressBar()
                withContext(Dispatchers.IO) {
                    blBridge.initUsers(3)
                }
            } catch (e: Exception) {
                updateErrorStatus("Error: ${e.message}")
            } finally {
                stopProgressBar()
            }
        }
    }

    fun refreshClicked() {
        viewModelScope.launch {
            try {
                startProgressBar()
                withContext(Dispatchers.IO) {
                    blBridge.refreshUsers(10)
                }
            } catch (e: Exception) {
                updateErrorStatus("Error: ${e.message}")
            } finally {
                stopProgressBar()
            }
        }
    }

    fun itemSelected(userPresentationEntity: UserPresentationEntity) {
        _displayOneItem.value = userPresentationEntity
        onEventNavigateToDetailed()
    }

    private fun updateErrorStatus(message: String) {
        _errorStatus.value = ErrorStatus.ErrorExists(message)
    }


    fun unsetErrorStatus() {
        _errorStatus.value = ErrorStatus.NoErrorExits
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

}

