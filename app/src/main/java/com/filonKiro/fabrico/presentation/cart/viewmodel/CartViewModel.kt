package com.filonKiro.fabrico.presentation.cart.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.filonKiro.fabrico.presentation.cart.events.CartEvent
import com.filonKiro.fabrico.presentation.cart.state.CartState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(

) : ViewModel(){

    var state by mutableStateOf(CartState())
        private set


    fun onEvent(event : CartEvent){
        when(event){
            is CartEvent.ApplyCoupon -> {

            }
            is CartEvent.ProceedToCheckout -> {

            }
            is CartEvent.EnterCoupon -> {
                state = state.copy(
                    couponEditText = event.couponText
                )
            }
        }
    }
}