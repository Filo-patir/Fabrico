package com.filonKiro.fabrico.presentation.cart

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.filonKiro.fabrico.R
import com.filonKiro.fabrico.presentation.ui.theme.interFontFamily

@Composable
fun CartScreen(modifier: Modifier = Modifier) {



    Scaffold(
        topBar = { CartTopAppBar() }
    ) {contentPadding->
        LazyColumn(
            modifier = modifier.padding(contentPadding)
        ) {
            items(20){
                CartItem()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartPreview(modifier: Modifier = Modifier) {
    CartScreen()
}

@Composable
fun CartTopAppBar(modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
    ){
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "My Cart",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = interFontFamily
        )
        CommonBackButton()
    }
}

@Composable
fun CommonBackButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(50.dp)
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        val context = LocalContext.current
        Icon(
            modifier = modifier
                .fillMaxSize()
                .border(1.dp, Color.LightGray, CircleShape)
                .clickable {
                    Toast
                        .makeText(context, "Kerolos", Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(5.dp),
            painter = painterResource(id = R.drawable.icon_arrow_back_long),
            contentDescription = null,
            tint = Color.Black
        )
    }

}