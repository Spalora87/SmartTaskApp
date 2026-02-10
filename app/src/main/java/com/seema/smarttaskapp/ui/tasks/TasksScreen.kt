package com.seema.smarttaskapp.ui.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seema.smarttaskapp.ui.components.AppTextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.seema.smarttaskapp.domain.task.Task


@Composable
fun TasksScreen(viewModel: TasksViewModel= hiltViewModel()){
    val uiState by viewModel.uiState.collectAsState()

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        AppTextField(value = uiState.taskName,
            onValueChanged = viewModel::onTaskNameChange,
            label = "Task Name",
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = viewModel::saveTask,
            enabled = !uiState.isLoading) {
            if(uiState.isLoading){
                CircularProgressIndicator(modifier = Modifier.size(20.dp))
            }
            else{
                Text("Save Task")
            }
        }
        LazyColumn {
            items(uiState.tasks){
                    task->
                Text(text=task.name,
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }



}