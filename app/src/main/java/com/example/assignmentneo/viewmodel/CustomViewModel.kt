package com.example.assignmentneo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentneo.model.HorizontalAndVerticalListModel
import com.example.assignmentneo.util.prepareData
import kotlinx.coroutines.launch

class CustomViewModel : ViewModel() {
    private val TAG = CustomViewModel::class.java.name
    private val _listMutableLiveData =
        MutableLiveData<List<HorizontalAndVerticalListModel>>()
    val listLiveData: LiveData<List<HorizontalAndVerticalListModel>>
        get() = _listMutableLiveData


    fun fetchDataToLoad() {
        viewModelScope.launch {
            _listMutableLiveData.value = prepareData()
        }
    }
}