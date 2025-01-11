package com.quick.app

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.quick.app.core.design.theme.MyAppTheme
import com.quick.app.feature.splash.SplashRoute
import com.quick.app.ui.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Change the color of StatusBar to white with transparent background
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))
        setContent {

            val navController = rememberNavController()

            MyAppTheme {
                MyApp(navController = navController)
            }

        }
    }
}

@Composable
fun MainScreen() {
    var isMainContentVisible by remember { mutableStateOf(false) }

    // 页面结构，条件渲染内容
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            if (isMainContentVisible) {
                // 主界面内容
                Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
            } else {
                // 欢迎页面和按钮
                ButtonSection(onButtonClick = {
                    Log.d("MainScreen", "Get Started clicked")
                    isMainContentVisible = true // 点击后显示主界面
                })
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to the main screen, $name!",
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun ButtonSection(onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to the app! Please click below to get started.")
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onButtonClick,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "Get Started")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
        MainScreen()
    }
}
