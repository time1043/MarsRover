package com.time1043.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.time1043.marsrover.nav.NavCompose
import com.time1043.marsrover.ui.theme.MarsRoverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarsRoverTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavCompose(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
