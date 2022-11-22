package com.umutcansahin.siparisver

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.umutcansahin.siparisver.datasource.DataSource
import com.umutcansahin.siparisver.model.MenuItem

@Composable
fun PizzaScreen(
    options: List<MenuItem.PizzaItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (MenuItem.PizzaItem) -> Unit,
    modifier: Modifier = Modifier
) {

    BaseMenuScreen(
        options = options,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        onCancelButtonClicked = onCancelButtonClicked ,
        onNextButtonClicked = onNextButtonClicked,
    )
}

@Preview
@Composable
private fun Preview() {
    PizzaScreen(
        options = DataSource.pizzaItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {}
    )
}