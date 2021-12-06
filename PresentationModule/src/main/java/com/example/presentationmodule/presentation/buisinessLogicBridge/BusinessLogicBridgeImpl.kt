package com.example.presentationmodule.presentation.buisinessLogicBridge

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.businesslogicmodule.businessLogic.entities.UserBusinessLogicEntity
import com.example.businesslogicmodule.businessLogic.repository.UserRepository
import com.example.businesslogicmodule.businessLogic.useCases.initUser.InitUserUseCaseBoundary
import com.example.businesslogicmodule.businessLogic.useCases.refreshUser.RefreshUserUseCaseBoundary
import com.example.presentationmodule.presentation.entities.UserPresentationEntity
import com.example.presentationmodule.presentation.entities.asPresentationEntity
import com.example.utilsmodule.utils.UsersDateUtils

class BusinessLogicBridgeImpl(
    userRepository: UserRepository,
    private val usersDateUtils: UsersDateUtils,
    private val initUserUseCase: InitUserUseCaseBoundary,
    private val refreshUserUseCase: RefreshUserUseCaseBoundary
) : BusinessLogicBridgeInterface {

    override val users: LiveData<List<UserPresentationEntity>> = Transformations.map(userRepository.users) { userBusinessLogicEntityList: List<UserBusinessLogicEntity> ->
        userBusinessLogicEntityList.map { userBusinessLogicEntity ->
            userBusinessLogicEntity.asPresentationEntity(usersDateUtils)
        }
    }

    override suspend fun refreshUsers(amount: Int) {
        refreshUserUseCase.execute(amount)
    }

    override suspend fun initUsers(amount: Int) {
        initUserUseCase.execute(amount)
    }


}


