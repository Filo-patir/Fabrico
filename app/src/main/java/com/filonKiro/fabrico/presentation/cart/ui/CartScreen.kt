package com.filonKiro.fabrico.presentation.cart.ui

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.filonKiro.fabrico.R
import com.filonKiro.fabrico.presentation.cart.events.CartEvent
import com.filonKiro.fabrico.presentation.cart.viewmodel.CartViewModel
import com.filonKiro.fabrico.presentation.ui.theme.interFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel = hiltViewModel()
) {



    BottomSheetScaffold(
        topBar = { CartTopAppBar() },
        sheetContent = { CartBottomSheet(cartViewModel = cartViewModel) }
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

@Preview(showSystemUi = true)
@Composable
fun CartBottomSheet(
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel = hiltViewModel()
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ApplyEditText(cartViewModel)
        Spacer(modifier = Modifier.height(30.dp))
        CustomPriceRow(title = "Sub-Total", price = "$400")
        Spacer(modifier = Modifier.height(15.dp))
        CustomPriceRow(title = "Discount", price = "-$20")
        Spacer(modifier = Modifier.height(15.dp))
        DashesSeparator()
        Spacer(modifier = Modifier.height(15.dp))
        CustomPriceRow(title = "Total Cost", price = "$380")
        Spacer(modifier = Modifier.height(15.dp))
        ProceedToCheckoutButton()
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun ProceedToCheckoutButton(

) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(context.getColor(R.color.semi_black)),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(60.dp),
            onClick = { }
        ) {
            Text(
                text = "Proceed to Checkout",
                fontSize = 15.sp,
                fontFamily = interFontFamily
            )
        }
    }
}

@Composable
fun DashesSeparator() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)
        .height(1.dp)) {
        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 3f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f),
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CustomPriceRow(
    modifier: Modifier = Modifier,
    title : String = "Sub-Total",
    price : String = "$400",
) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontFamily = interFontFamily,
            fontSize = 15.sp,
            color = Color(context.getColor(R.color.gray))
        )
        Text(
            text = price,
            fontFamily = interFontFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ApplyEditText(cartViewModel: CartViewModel = hiltViewModel()) {

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.LightGray, RoundedCornerShape(50.dp))
                .height(50.dp)
                .padding(start = 10.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 10.dp),
                contentAlignment = Alignment.CenterStart
            ){
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp),
                    value = cartViewModel.state.couponEditText,
                    onValueChange = {
                        cartViewModel.onEvent(CartEvent.EnterCoupon(it))
                    },
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                    )

                if(cartViewModel.state.couponEditText.isEmpty()){
                    Text(text = "Promo Code", fontFamily = interFontFamily,
                        color = Color(context.getColor(R.color.gray)))
                }
            }


            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(context.getColor(R.color.semi_black)),
                    contentColor = Color.White
                ),
                
            ) {
                Text(text = "Apply", fontFamily = interFontFamily)
            }
        }
    }
}

