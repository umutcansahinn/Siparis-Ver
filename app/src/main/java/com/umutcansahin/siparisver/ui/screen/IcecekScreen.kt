package com.umutcansahin.siparisver

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.umutcansahin.siparisver.datasource.DataSource
import com.umutcansahin.siparisver.model.MenuItem

@Composable
fun IcecekScreen(
    options: List<MenuItem.IcecekItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (MenuItem.IcecekItem) -> Unit,
    modifier: Modifier = Modifier
) {

    BaseMenuScreen(
        options = options,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        onNextButtonClicked = onNextButtonClicked,
        onCancelButtonClicked = onCancelButtonClicked
    )
}

@Preview
@Composable
private fun Preview() {
    IcecekScreen(
        options = DataSource.icecekItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {}
    )
}