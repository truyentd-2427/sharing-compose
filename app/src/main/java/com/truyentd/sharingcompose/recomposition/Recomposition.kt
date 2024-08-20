package com.truyentd.sharingcompose.recomposition

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecompositionExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Recompositon Example",
                        fontWeight = FontWeight.W500,
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).padding(24.dp)) {
            Greeting3()
        }
    }
}


/** List example about Recomposition */

// Example 1

@Composable
fun Greeting() {
    var state by remember { mutableStateOf("Hi Compose") }
    LogCompositions(message = "Greeting Scope")
    Text(text = state)
    Button(
        modifier = Modifier.padding(top = 32.dp),
        onClick = {
            state = "Hi Compose ${Random.nextInt()}"
        },
    ) {
        LogCompositions(message = "Button Scope")
        Text(text = "Click Me!")
    }
}

// Example 2

@Composable
fun Greeting2() {
    var state by remember { mutableStateOf("Hi Compose") }
    LogCompositions(message = "Greeting Scope")

    Text(text = "Hi Compose!")
    Button(
        modifier = Modifier.padding(top = 32.dp),
        onClick = {
            state = "Hi Compose! ${Random.nextInt()}"
        },
    ) {
        LogCompositions(message = "Button Scope")
        Text(text = state)
    }
}


// Example 3

@Composable
fun Greeting3() {
    var state by remember { mutableStateOf("Hi Compose") }
    LogCompositions(message = "Greeting Scope")

    Column { // We add new component here
        LogCompositions(message = "Column Scope")

        Text(text = state)
        Button(
            onClick = { state = "Hi Compose ${Random.nextInt()}" },
        ) {
            LogCompositions(message = "Button Scope")
            Text(text = "Click Me!")
        }
    }
}

// Example 4

@Composable
fun Greeting4() {
    var state by remember { mutableStateOf("Hi Compose") }
    LogCompositions(message = "Greeting Scope")

    Column { // We add new component here
        LogCompositions(message = "Column Scope")
        Text(text = state)
        Text(text = "Never change")
        Button(
            onClick = { state = "Hi Compose! ${Random.nextInt()}" },
        ) {
            LogCompositions(message = "Button Scope")
            Text(text = "Click Me!")
        }
    }
}
