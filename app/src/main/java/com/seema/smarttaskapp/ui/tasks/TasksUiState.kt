package com.seema.smarttaskapp.ui.tasks

data class TasksUiState(val taskName:String="",
                        val isLoading:Boolean=false,
                        val error:String?=null)