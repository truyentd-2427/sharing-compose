package com.truyentd.sharingcompose.sideeffect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProduceStateExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "produceState Example",
                        fontWeight = FontWeight.W500,
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CountdownTimer(initialTime = 10)
        }
    }
}


@Composable
fun CountdownTimer(initialTime: Int) {
    // Produce a state that counts down from the initialTime
    val timeLeft by produceState(initialTime) {
        for (i in initialTime downTo 0) {
            value = i
            delay(1000L)
        }
    }

    // UI that displays the time left
    Text(text = "Time left: $timeLeft seconds", fontWeight = FontWeight.W500, fontSize = 32.sp)
}
