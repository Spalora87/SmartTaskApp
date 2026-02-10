package com.seema.smarttaskapp.data.local.task

import com.seema.smarttaskapp.domain.task.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository{
    suspend fun addTask(task: Task)
     fun observeTasks(): Flow<List<Task>>
}