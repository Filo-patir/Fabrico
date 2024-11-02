package com.filonKiro.fabrico.presentation.cart.events

sealed class CartEvent {
    data class ApplyCoupon(val coupon : String) : CartEvent()
    data class ProceedToCheckout(val totalPrice : Double) : CartEvent()
    data class EnterCoupon(val couponText : String) : CartEvent()
}