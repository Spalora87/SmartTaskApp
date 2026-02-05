package com.seema.smarttaskapp.di

import com.seema.smarttaskapp.data.local.task.TaskRepository
import com.seema.smarttaskapp.data.local.task.TaskRepositoryImpl
import com.seema.smarttaskapp.domain.task.AddTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object TaskModule {

    @Provides
    fun provideTaskRepository(): TaskRepository = TaskRepositoryImpl()

    @Provides
    fun provideAddTaskUseCase(repository: TaskRepository):
            AddTaskUseCase = AddTaskUseCase(repository)

}