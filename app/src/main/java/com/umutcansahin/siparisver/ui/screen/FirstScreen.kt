package com.umutcansahin.siparisver

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    onGivePizzaOrderButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onGivePizzaOrderButtonClicked ,
            modifier = modifier.widthIn(250.dp)
        ) {
            Text(text = stringResource(R.string.give_pizza_order))
        }
    }
}


@Preview
@Composable
private fun Preview() {
    FirstScreen(
        onGivePizzaOrderButtonClicked = { }
    )
}