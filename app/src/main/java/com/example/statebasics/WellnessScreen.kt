package com.example.statebasics

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var waterCount by rememberSaveable { mutableStateOf(0) }


    Column(modifier = modifier) {
        StateLessCounter(count = waterCount, onIncrement = { waterCount++ }, modifier)

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask ={task,checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )

    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }