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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statehoisting.ui.theme.WellnessTaskItem

@Composable
fun HomeScreen() {
    WaterCounter()
}

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            var showTask by rememberSaveable {
                mutableStateOf(true)
            }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }
            Text(
                text = "You've had $count glasses.",
            )
        }
        Row {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(top = 16.dp),
                enabled = count < 10
            ) {
                Text(
                    text = "I had a glass of water"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = { count = 0 },
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
    WaterCounter()
}