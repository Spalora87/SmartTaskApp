package com.seema.smarttaskapp.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(value:String,
                 onValueChanged:(String)->Unit,
                 label:String,
                 modifier: Modifier=Modifier){

    OutlinedTextField(value=value,
        onValueChange=onValueChanged,
        label={ Text(label)},
        modifier=modifier,
        shape = RoundedCornerShape(12.dp))

}