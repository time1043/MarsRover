package com.time1043.marsrover.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.time1043.marsrover.nav.Destinations.Home
import com.time1043.marsrover.nav.Destinations.Manifest
import com.time1043.marsrover.ui.theme.MarsRoverTheme
import com.time1043.marsrover.ui.view.ManifestScreen
import com.time1043.marsrover.ui.view.RoverList

@Composable
fun NavCompose(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    MarsRoverTheme {
        NavHost(navController = navController, startDestination = Home, modifier = modifier) {
            composable(Home) {
                RoverList() { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest) { backStackEntry ->
                ManifestScreen(roverName = backStackEntry.arguments?.getString("roverName") ?: "")
            }
        }
    }
}