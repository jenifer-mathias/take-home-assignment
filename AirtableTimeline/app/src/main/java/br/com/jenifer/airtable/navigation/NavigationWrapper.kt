package br.com.jenifer.airtable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jenifer.airtable.ui.timeline.TimelineScreen

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Timeline) {

        composable<Timeline> {
            TimelineScreen()
        }
    }
}
