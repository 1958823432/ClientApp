package com.quick.app.feature.main

import android.graphics.pdf.PdfDocument.Page
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainRoute(
	finishPage: () -> Unit,
){
	MainScreen(
		finishPage = finishPage
	)
}

@Composable
fun MainScreen(
	finishPage: () -> Unit = {},
)
{
	Column {
		Text(text = "MainScreen")
		Button(onClick = {
			// Handle button click
		}) {
			Text(text = "Click Me")
		}
	}
}