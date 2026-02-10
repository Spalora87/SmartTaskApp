package com.seema.smarttaskapp.domain.task

import com.seema.smarttaskapp.data.local.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase (private val repository: TaskRepository){

    operator fun invoke():Flow<List<Task>>{
        return repository.observeTasks()
    }

}