package com.umutcansahin.siparisver.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.umutcansahin.siparisver.model.MenuItem
import com.umutcansahin.siparisver.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class SiparisViewModel : ViewModel() {

    private val taxRate = 0.08

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun updatePizza(pizza: MenuItem.PizzaItem) {
        val previousPizza = _uiState.value.pizza
        updateItem(pizza, previousPizza)
    }
    fun updateHamur(hamur: MenuItem.HamurItem){
        val previousHamur = _uiState.value.hamur
        updateItem(hamur,previousHamur)
    }
    fun updateIcecek(icecek: MenuItem.IcecekItem){
        val previousIcecek = _uiState.value.icecek
        updateItem(icecek,previousIcecek)
    }


    fun resetOrder() {
        _uiState.value = OrderUiState()
    }




    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update {
            val previousItemPrice = previousItem?.price ?: 0.0
            val itemTotalPrice = it.itemTotalPrice - previousItemPrice + newItem.price
            val tax = itemTotalPrice * taxRate
            it.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                pizza = if (newItem is MenuItem.PizzaItem) {
                    newItem
                } else {
                    it.pizza
                },
                hamur = if (newItem is MenuItem.HamurItem) {
                    newItem
                } else {
                    it.hamur
                },
                icecek = if (newItem is MenuItem.IcecekItem) {
                    newItem
                } else {
                    it.icecek
                }
            )
        }
    }
}

fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}