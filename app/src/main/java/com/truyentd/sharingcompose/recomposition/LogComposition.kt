package com.truyentd.sharingcompose.recomposition

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember

class Ref(var value: Int)

@Composable
inline fun LogCompositions(message: String) {
    var ref = remember { Ref(0) }
    SideEffect { ref.value++ }
    Log.d("RecompositionLog", "Compositions: $message ${ref.value}")
}
