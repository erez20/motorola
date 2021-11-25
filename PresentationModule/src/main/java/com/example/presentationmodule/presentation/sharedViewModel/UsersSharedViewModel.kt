package com.example.presentationmodule.presentation.sharedViewModel

import androidx.lifecycle.*
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.businesslogicmodule.businessLogic.useCases.InitUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.RefreshUserUseCase
import com.example.businesslogicmodule.businessLogic.useCases.UseCase
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import com.example.presentationmodule.presentation.entities.asPresentationEntity
import com.example.utilsmodule.utils.UsersDateUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsersSharedViewModel(
    private val userRepository: UserRepository,
    private val usersDateUtils: UsersDateUtils,
    private val initUserUseCase: UseCase,
    private val refreshUserUseCase: RefreshUserUseCase
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

    private val _errorStatus : MutableLiveData<ErrorStatus> = MutableLiveData(ErrorStatus.NoErrorExits)
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
                    initUserUseCase.execute()
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
                    refreshUserUseCase.execute()
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

