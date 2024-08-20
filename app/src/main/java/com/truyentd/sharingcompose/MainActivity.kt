package com.truyentd.sharingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.truyentd.sharingcompose.navigation.AppNavHost
import com.truyentd.sharingcompose.recomposition.RecompositionExample
import com.truyentd.sharingcompose.sideeffect.DerivedStateExample
import com.truyentd.sharingcompose.sideeffect.LaunchedEffectExample
import com.truyentd.sharingcompose.sideeffect.ProduceStateExample
import com.truyentd.sharingcompose.sideeffect.RememberCoroutineScopeExample
import com.truyentd.sharingcompose.ui.theme.SharingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharingComposeTheme {
                ProduceStateExample()
            }
        }
    }
}
