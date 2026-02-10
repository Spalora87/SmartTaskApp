package com.seema.smarttaskapp.domain.task

import com.seema.smarttaskapp.data.local.task.TaskRepository

class AddTasksUseCase(private val repository: TaskRepository){

    suspend operator fun invoke(taskName:String){
        if(taskName.isBlank()){
            throw IllegalArgumentException("Task Name cannot be empty")
        }

        val task= Task(id=System.currentTimeMillis(),
            taskName)

        repository.addTask(task)
    }
}