package com.filonKiro.fabrico.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Splash Screen")
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}