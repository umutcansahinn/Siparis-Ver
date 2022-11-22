package com.umutcansahin.siparisver

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.umutcansahin.siparisver.datasource.DataSource
import com.umutcansahin.siparisver.model.MenuItem

@Composable
fun HamurScreen(
    options: List<MenuItem.HamurItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (MenuItem.HamurItem) -> Unit,
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
    HamurScreen(
        options = DataSource.hamurItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {}
    )
}