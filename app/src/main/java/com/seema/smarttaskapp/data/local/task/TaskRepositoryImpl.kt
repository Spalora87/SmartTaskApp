package com.seema.smarttaskapp.data.local.task

import com.seema.smarttaskapp.domain.task.Task
import kotlinx.coroutines.delay

class TaskRepositoryImpl:TaskRepository{

    private val tasks= mutableListOf<Task>()
    override suspend fun addTask(task: Task) {
        delay(500)
        tasks.add(task)
    }

    override suspend fun getTasks(): List<Task> {
        return tasks
    }

}