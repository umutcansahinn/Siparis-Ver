package com.umutcansahin.siparisver

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutcansahin.siparisver.datasource.DataSource
import com.umutcansahin.siparisver.model.MenuItem
import com.umutcansahin.siparisver.model.OrderUiState
import com.umutcansahin.siparisver.ui.viewmodel.formatPrice

@Composable
fun HesapScreen(
    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier

) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.siparis_özeti),
            fontWeight = FontWeight.Bold
        )
        ItemSummary(item = orderUiState.pizza)
        ItemSummary(item = orderUiState.hamur)
        ItemSummary(item = orderUiState.icecek)
        Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 8.dp))

        OrderSubCost(
            resourceId = R.string.tutar,
            price = orderUiState.itemTotalPrice.formatPrice(),
            Modifier.align(Alignment.End)
        )
        OrderSubCost(
            resourceId = R.string.kdv,
            price = orderUiState.orderTax.formatPrice(),
            Modifier.align(Alignment.End)
        )
        Text(
            text = stringResource(
                id = R.string.toplam_tutar,
                orderUiState.orderTotalPrice.formatPrice()
            ),
            modifier = modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold
        )


        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel).uppercase())
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.submit).uppercase())
            }

        }
    }
}

@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item?.name ?: "")
        Text(text = item?.getFormattedPrice() ?: "")

    }
}

@Composable
fun OrderSubCost(
    @StringRes resourceId: Int,
    price: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = resourceId, price),
        modifier = modifier
    )
}

@Preview
@Composable
private fun Preview() {
    HesapScreen(
        orderUiState = OrderUiState(
            pizza = DataSource.pizzaItems[0],
            hamur = DataSource.hamurItems[0],
            icecek = DataSource.icecekItems[0],
            itemTotalPrice = 12.99,
            orderTax = 1.99,
            orderTotalPrice = 5.00
        ),
        onNextButtonClicked = {},
        onCancelButtonClicked = {}
    )
}