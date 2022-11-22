package com.umutcansahin.siparisver.datasource

import com.umutcansahin.siparisver.model.MenuItem

object DataSource {

    val pizzaItems = listOf(
        MenuItem.PizzaItem(
            name = "Sucuklu Pizza",
            description = "sucuk,domates sosu,kekik",
            price = 12.99
        ),
        MenuItem.PizzaItem(
            name = "Karisik Pizza",
            description = "sucuk,sosis,salam,domates sosu,kekik",
            price = 16.99
        ),
        MenuItem.PizzaItem(
            name = "Margarita Pizza",
            description = "peynir,zeytin yagi",
            price = 13.00
        )
    )
    val hamurItems = listOf(
        MenuItem.HamurItem(
            name = "ince hamur",
            description = "inceltilmis hamur",
            price = 1.99
        ),
        MenuItem.HamurItem(
            name = "normal hamur",
            description = "normal hamur",
            price = 1.00
        ),
        MenuItem.HamurItem(
            name = "kalin hamur",
            description = "kalin hamur",
            price = 1.55
        ),
        MenuItem.HamurItem(
            name = "dolgu kenar hamur",
            description = "kenarlari peynir dolgulu",
            price = 3.00
        )
    )

    val icecekItems = listOf(
        MenuItem.IcecekItem(
            name = "ayran",
            description = "acik ayran",
            price = 5.00
        ),
        MenuItem.IcecekItem(
            name = "fanta",
            description = "sari kola",
            price = 7.50
        ),
        MenuItem.IcecekItem(
            name = "cola",
            description = "siyah kola",
            price = 7.50
        ),MenuItem.IcecekItem(
            name = "salgam",
            description = "acılı",
            price = 7.50
        ),MenuItem.IcecekItem(
            name = "salgam",
            description = "acısız",
            price = 7.50
        ),MenuItem.IcecekItem(
            name = "su",
            description = "su",
            price = 7.50
        ),

    )
}