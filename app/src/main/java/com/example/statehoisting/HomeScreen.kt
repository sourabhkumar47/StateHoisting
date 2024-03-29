package com.example.statehoisting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statehoisting.ui.theme.WellnessTaskItem

@Composable
fun HomeScreen() {
    Column {
        StateFullCounter()

        val list = remember {
            getWellnessTasks().toMutableStateList()
        }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })

    }
}

private fun getWellnessTasks() = List(300) { i ->
    WellnessTask(i, "Task # $i")
}

//Stateful composable
@Composable
fun StateFullCounter() {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    //calling the stateless composable
    WaterCounter(count = count, onIncrement = { count++ }, onClear = { count = 0 })


}

//Stateless composable
@Composable
fun WaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
// Removed this state and added as parameters to make the composable stateless
//    var count by rememberSaveable {
//        mutableIntStateOf(0)
//    }

    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
//            var showTask by rememberSaveable {
//                mutableStateOf(true)
//            }
//            if (showTask) {
//                WellnessTaskItem(
//                    onClose = { showTask = false },
//                    taskName = "Have you taken your 15 minute walk today?"
//                )
//            }
            Text(
                text = "You've had $count glasses.",
            )
        }
        Row {
            Button(
                onClick = onIncrement,
                modifier = Modifier.padding(top = 16.dp),
                enabled = count < 10
            ) {
                Text(
                    text = "I had a glass of water"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = onClear,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Clear"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter(
        count = 0,
        onIncrement = {},
        onClear = {}
    )
}