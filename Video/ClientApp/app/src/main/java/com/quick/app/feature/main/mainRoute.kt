package com.quick.app.feature.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quick.app.feature.splash.SPLASH_ROUTE
import com.quick.app.feature.splash.SplashRoute
import com.quick.app.feature.splash.splashScreen

const val MAIN_ROUTE = "main"

fun NavController.navigateToMain(): Unit {
    navigate(MAIN_ROUTE){
        launchSingleTop = true

        popUpTo(SPLASH_ROUTE){ inclusive = true }
    }
}

fun NavGraphBuilder.mainScreen(
    finishPage: () -> Unit,
)
{
    composable(MAIN_ROUTE)
    {
        MainRoute(finishPage = finishPage)
    }
}