package com.seema.smarttaskapp.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(buttonName:String,
                  onClick:()->Unit,
                  modifier: Modifier=Modifier){
    Button(onClick,modifier, shape = RoundedCornerShape(12.dp)){
        Text(buttonName)
    }

}