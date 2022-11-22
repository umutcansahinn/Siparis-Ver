package com.umutcansahin.siparisver

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.umutcansahin.siparisver.model.MenuItem

@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        options.forEach { item ->

            PizzaItemRow(
                item = item,
                selectedItemName = selectedItemName,
                onSelectionItemChanged = { selectedItemName = item.name },
                onSelectionChanged = onSelectionChanged
            )
        }
        ButtonGroup(
            selectedItemName = selectedItemName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked =  onNextButtonClicked
        )
    }
}

@Composable
fun PizzaItemRow(
    item: MenuItem,
    selectedItemName: String,
    onSelectionItemChanged: (String) -> Unit,
    onSelectionChanged: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.selectable(
            selected = selectedItemName == item.name,
            onClick = {
                onSelectionItemChanged(item.name)
                onSelectionChanged(item)
            }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedItemName == item.name,
            onClick = {
                onSelectionItemChanged(item.name)
                onSelectionChanged(item)
            })
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = item.getFormattedPrice(),
                style = MaterialTheme.typography.body2
            )
            Divider(thickness = 1.dp, modifier = modifier.padding(16.dp))
        }

    }
}

@Composable
fun ButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(
            modifier = modifier
                .weight(1f),
            onClick =  onCancelButtonClicked
        ) {
            Text(text = stringResource(R.string.cancel).uppercase())
        }
        Button(
            modifier = modifier.weight(1f),
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(text = stringResource(R.string.next).uppercase())

        }

    }
}