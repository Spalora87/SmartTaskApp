package com.seema.smarttaskapp.ui.tasks

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seema.smarttaskapp.domain.task.AddTasksUseCase
import com.seema.smarttaskapp.domain.task.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val addTasksUseCase: AddTasksUseCase,
    private val getTasksUseCase: GetTasksUseCase):ViewModel(){

    private val _uiState= MutableStateFlow(TasksUiState())
    val uiState:StateFlow<TasksUiState> = _uiState

    init {
        observerTasks()
    }

   private  fun observerTasks(){
        viewModelScope.launch {
            Log.d("VM_DEBUG", "Collect started")
            getTasksUseCase().collect{taskList->
                Log.d("TASKS_DEBUG", "Tasks size = ${taskList.size}")
                _uiState.update {
                    it.copy(tasks = taskList)
                }
            }

        }
    }
    fun onTaskNameChange(newValue:String){
        _uiState.value=_uiState.value.copy(
            taskName = newValue
        )
    }


    fun saveTask(){
        viewModelScope.launch {
          try{
              _uiState.update { it.copy(isLoading = true) }
              addTasksUseCase(uiState.value.taskName)
              _uiState.update {
                  it.copy(
                      taskName = "",
                      isLoading = false,
                      error = null
                  )
              }

          }
          catch (e:Exception){
                _uiState.update {
                    it.copy(isLoading = false, error = e.message)
                }
          }
        }
    }

}