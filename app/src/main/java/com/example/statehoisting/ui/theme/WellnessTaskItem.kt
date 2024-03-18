package com.example.statehoisting.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
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

        IconButton(onClick = onClose) {
            Icon(Icons.Default.Clear, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WellnessTaskItemPreview() {
    WellnessTaskItem(
        taskName = "Have you taken your 15 minute walk today?",
        onClose = {},
        modifier = Modifier
    )
}
