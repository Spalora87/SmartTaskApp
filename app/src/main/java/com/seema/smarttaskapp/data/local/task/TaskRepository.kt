package com.seema.smarttaskapp.data.local.task

import com.seema.smarttaskapp.domain.task.Task

interface TaskRepository{
    suspend fun addTask(task: Task)
    suspend fun getTasks():List<Task>
}