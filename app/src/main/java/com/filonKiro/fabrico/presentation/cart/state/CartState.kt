package com.filonKiro.fabrico.presentation.cart.state

data class CartState(
    val isLoading : Boolean = false,
    //val products : List<Product> = emptyList(),
    val error : String = "",
    val couponEditText : String = "",
    val totalPrice : String = "",
    val subTotalPrice : String = "",
    val discount : String = "",
)
