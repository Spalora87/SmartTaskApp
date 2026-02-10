package com.seema.smarttaskapp.data.local.task

import android.util.Log
import com.seema.smarttaskapp.domain.task.Task
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor():TaskRepository{

    private val tasksFlow= MutableStateFlow<List<Task>>(emptyList())

    init {
        Log.d("REPO_DEBUG", "Repository created")
        Log.d("REPO_DEBUG", "Repository instance = ${this.hashCode()}")
    }
    override suspend fun addTask(task: Task) {
        tasksFlow.value = tasksFlow.value + task
        Log.d("REPO_DEBUG", "Task added: ${task.name}")
        Log.d("REPO_DEBUG", "Total tasks: ${tasksFlow.value.size}")
    }

    override fun observeTasks(): Flow<List<Task>> {
        Log.d("REPO_DEBUG", "observeTasks called")

        return tasksFlow
    }


}