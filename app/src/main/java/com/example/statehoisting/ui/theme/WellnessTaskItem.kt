package com.example.statehoisting.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Stateless composable
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        )

        Checkbox(checked = checked, onCheckedChange = onCheckChange)

        IconButton(onClick = onClose) {
            Icon(Icons.Default.Clear, contentDescription = "Close")
        }
    }
}

//Stateful composable
@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckChange = { checkedState = it },
        onClose = onClose,
        modifier = modifier,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WellnessTaskItemPreview() {
    WellnessTaskItem(
        taskName = "Have you taken your 15 minute walk today?",
        onClose = {},
        checked = false,
        onCheckChange = {},
        modifier = Modifier
    )
}
