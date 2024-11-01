package com.filonKiro.fabrico.presentation.cart

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.filonKiro.fabrico.R
import com.filonKiro.fabrico.presentation.ui.theme.interFontFamily

@Composable
fun CartItem(modifier: Modifier = Modifier) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp)
        ){
            AsyncImage (
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://i.pinimg.com/originals/13/ac/c5/13acc5169bb5040b48a38168be255cde.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop
                )

            Spacer(modifier = modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Product Name", fontFamily = interFontFamily, maxLines = 1, fontWeight = FontWeight.Bold)
                Spacer(modifier = modifier.height(20.dp))
                Text(text = "Size : XL", fontFamily = interFontFamily, color = Color.Gray)
                Spacer(modifier = modifier.height(20.dp))
                Text(text = "$2000", fontFamily = interFontFamily,maxLines = 1, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = modifier.width(10.dp))

            Box (
                modifier = Modifier.weight(1f).fillMaxHeight()
                    .padding(bottom = 10.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                AddAndRemoveView()
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray))


    }

}

@Preview(showBackground = true)
@Composable
fun CartItemPreview(modifier: Modifier = Modifier) {
    CartItem()
}

@Composable
fun AddAndRemoveView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        CustomAddOrRemoveButton(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color(context.getColor(R.color.light_gray))),
            iconColor = Color(context.getColor(R.color.semi_black)),
            icon = R.drawable.icon_remove
        ) {
            Toast
                .makeText(context, "Quantity decreased by 1", Toast.LENGTH_SHORT)
                .show()
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "1",
            fontWeight = FontWeight.Bold,
            fontFamily = interFontFamily
        )


        Spacer(modifier = Modifier.width(10.dp))

        CustomAddOrRemoveButton(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color(context.getColor(R.color.semi_black))),
            iconColor = Color(context.getColor(R.color.light_gray)),
            icon = R.drawable.icon_add
        ) {
            Toast
                .makeText(context, "Quantity increased by 1", Toast.LENGTH_SHORT)
                .show()
        }

    }
}

@Composable
fun CustomAddOrRemoveButton(
    modifier: Modifier,
    iconColor : Color,
    icon: Int,
    onClick: () -> Unit
) {

    val context = LocalContext.current
    Icon(
        modifier = modifier
            .size(25.dp)
            .padding(3.dp)
            .clickable {
                onClick()
            },
        painter = painterResource(id = icon),
        contentDescription = "",
        tint = iconColor
    )
}