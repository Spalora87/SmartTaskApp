package com.seema.smarttaskapp.ui.tasks

import com.seema.smarttaskapp.domain.task.Task

data class TasksUiState(val taskName:String="",
                        val tasks:List<Task> = emptyList(),
                        val isLoading:Boolean=false,
                        val error:String?=null)