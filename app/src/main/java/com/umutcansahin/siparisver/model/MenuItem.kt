package com.umutcansahin.siparisver.model

import java.text.NumberFormat

sealed class MenuItem(
    open val name: String,
    open val description: String,
    open val price: Double
) {
    data class PizzaItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    data class HamurItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ): MenuItem(name,description,price)

    data class IcecekItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ): MenuItem(name,description,price)


    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}
