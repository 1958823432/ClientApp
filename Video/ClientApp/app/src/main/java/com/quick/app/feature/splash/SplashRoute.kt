package com.quick.app.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quick.app.R
import com.quick.app.core.design.theme.MyAppTheme
import com.quick.app.util.SuperDateUtil

@Composable
fun SplashRoute() {
    SplashScreen(
        year = SuperDateUtil.currentYear(),
    )
}

@Composable
fun SplashScreen(year: Int = 2024) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier
                .wrapContentSize()
                .offset(y = (-50).dp)
        )

        Text(
            text = "Welcome to MyApp!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )

        Text(
            text = stringResource(id = R.string.copyright, year),
            color = MaterialTheme.colorScheme.onPrimary,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 12.sp
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-50).dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashRoutePreview() {
    MyAppTheme {
        SplashRoute()
    }
}
