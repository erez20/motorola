package com.example.presentationmodule.presentation.sharedViewModel

sealed class ErrorStatus()  {
    class ErrorExists(val errorMessage: String) : ErrorStatus()
    object NoErrorExits : ErrorStatus()
}