package com.quick.app.feature.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quick.app.R
import com.quick.app.core.design.theme.MyAppTheme
import com.quick.app.feature.main.MAIN_ROUTE
import com.quick.app.util.SuperDateUtil

@Composable
fun SplashRoute(
    toMain: () -> Unit,
    ) {
    SplashScreen(
        year = SuperDateUtil.currentYear(),
        toMain = toMain
    )
}

@Composable
fun SplashScreen(
    year: Int = 2024,
    toMain: () -> Unit = {},
    ) {
    // 定义垂直渐变背景
    val gradient = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.primary
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        // 动画应用Logo
        val infiniteTransition = rememberInfiniteTransition()
        val scale by infiniteTransition.animateFloat(
            initialValue = 0.8f,
            targetValue = 1.2f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale)
                .size(120.dp) // 根据需要调整大小
        )

        // 欢迎文本
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 200.dp), // 调整内边距以将文本置于Logo下方
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "自分だけの物語を描こう",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your journey starts here.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White.copy(alpha = 0.8f)
                ),
                textAlign = TextAlign.Center
            )
        }

        // 底部部分包含版权信息和按钮
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { toMain() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(
                    text = "Get Started",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.copyright, year),
                color = Color.White.copy(alpha = 0.6f),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    MyAppTheme {
        SplashRoute({})
    }
}
