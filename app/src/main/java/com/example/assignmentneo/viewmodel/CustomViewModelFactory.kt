package com.example.assignmentneo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CustomViewModel::class.java)) {
            CustomViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}