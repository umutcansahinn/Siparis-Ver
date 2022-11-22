package com.umutcansahin.siparisver.model

data class OrderUiState(
    val pizza: MenuItem.PizzaItem? = null,
    val hamur: MenuItem.HamurItem? = null,
    val icecek: MenuItem.IcecekItem? = null,
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.0,
    val orderTotalPrice: Double = 0.0
)
