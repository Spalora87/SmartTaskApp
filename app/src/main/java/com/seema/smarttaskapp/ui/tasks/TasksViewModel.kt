package com.seema.smarttaskapp.ui.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seema.smarttaskapp.domain.task.AddTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val addTaskUseCase: AddTaskUseCase):ViewModel(){
    private val _uiState= mutableStateOf(TasksUiState())
    val uiState:State<TasksUiState> = _uiState


    fun onTaskNameChange(newValue:String){
        _uiState.value=_uiState.value.copy(
            taskName = newValue
        )
    }


    fun saveTask(){
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)
                addTaskUseCase(_uiState.value.taskName)
                _uiState.value = TasksUiState()
            }
            catch (e:Exception){
                _uiState.value=_uiState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }


        }
    }

}