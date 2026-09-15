package com.time1043.marsrover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.time1043.marsrover.ui.theme.MarsRoverTheme
import com.time1043.marsrover.ui.view.Rover

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarsRoverTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Rover(
                        name = "Perseverance",
                        img = R.drawable.perseverance,
                        landingDate = "18 February 2021",
                        distanceTraveled = "12.56 km",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
