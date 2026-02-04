package com.seema.smarttaskapp.ui.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor():ViewModel(){
    private val _uiState= mutableStateOf(TasksUiState())
    val uiState:State<TasksUiState> = _uiState


    fun onTaskNameChange(newValue:String){
        _uiState.value=_uiState.value.copy(
            taskName = newValue
        )
    }


    fun saveTask(){
        viewModelScope.launch {
            _uiState.value=_uiState.value.copy(isLoading = true)
            delay(1000)

            _uiState.value=_uiState.value.copy(
                isLoading = false,
                taskName = ""
            )
        }
    }

}