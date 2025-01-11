package com.quick.app.feature.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.quick.app.feature.main.MAIN_ROUTE

const val SPLASH_ROUTE = "splash"

fun NavGraphBuilder.splashScreen(toMain: () -> Unit,)
{
	composable(SPLASH_ROUTE)
	{
		SplashRoute(toMain = toMain)
	}
}
