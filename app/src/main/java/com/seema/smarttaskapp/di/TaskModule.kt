package com.seema.smarttaskapp.di

import com.seema.smarttaskapp.data.local.task.TaskRepository
import com.seema.smarttaskapp.data.local.task.TaskRepositoryImpl
import com.seema.smarttaskapp.domain.task.AddTasksUseCase
import com.seema.smarttaskapp.domain.task.GetTasksUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  TaskModule {

    @Provides
    @Singleton
    fun provideRepo(): TaskRepository = TaskRepositoryImpl()

    @Provides
    fun provideAddTaskUseCase(repository: TaskRepository):
            AddTasksUseCase = AddTasksUseCase(repository)

    @Provides
    fun provideGetTasksUseCase(repository: TaskRepository):
            GetTasksUseCase = GetTasksUseCase(repository)

}