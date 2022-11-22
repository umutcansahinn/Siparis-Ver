package com.umutcansahin.siparisver.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.umutcansahin.siparisver.*
import com.umutcansahin.siparisver.R
import com.umutcansahin.siparisver.datasource.DataSource
import com.umutcansahin.siparisver.ui.viewmodel.SiparisViewModel

enum class SiparisVerScreen(@StringRes val title: Int) {
    Birinci(R.string.birinci_ekran),
    Ikinci(R.string.ikinci_ekran),
    Ucuncu(R.string.ucuncu_ekran),
    Dorduncu(R.string.dortuncu_ekran),
    Besinci(R.string.bescinci_ekran)
}


@Composable
fun SiparisVerAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }
    )
}


@Composable
fun SiparisVerApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel: SiparisViewModel = viewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = SiparisVerScreen.valueOf(
        backStackEntry?.destination?.route ?: SiparisVerScreen.Birinci.name
    )

    Scaffold(
        topBar = {
            SiparisVerAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )

        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SiparisVerScreen.Birinci.name,
            modifier = modifier.padding(it)
        ) {
            composable(route = SiparisVerScreen.Birinci.name) {
                FirstScreen(
                    onGivePizzaOrderButtonClicked = { navController.navigate(SiparisVerScreen.Ikinci.name) }
                )
            }
            composable(route = SiparisVerScreen.Ikinci.name) {
                PizzaScreen(
                    options = DataSource.pizzaItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(SiparisVerScreen.Birinci.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(SiparisVerScreen.Ucuncu.name)
                    },
                    onSelectionChanged = {
                        viewModel.updatePizza(it)
                    }
                )
            }
            composable(route = SiparisVerScreen.Ucuncu.name) {
                HamurScreen(
                    options = DataSource.hamurItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(SiparisVerScreen.Birinci.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(SiparisVerScreen.Dorduncu.name)
                    },
                    onSelectionChanged = {
                        viewModel.updateHamur(it)
                    }
                )
            }
            composable(route = SiparisVerScreen.Dorduncu.name) {
                IcecekScreen(
                    options = DataSource.icecekItems,
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(SiparisVerScreen.Birinci.name, inclusive = false)
                    },
                    onNextButtonClicked = {
                        navController.navigate(SiparisVerScreen.Besinci.name)
                    },
                    onSelectionChanged = {
                        viewModel.updateIcecek(it)
                    }
                )
            }
            composable(route = SiparisVerScreen.Besinci.name) {
                HesapScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(SiparisVerScreen.Birinci.name, inclusive = false)
                    },
                    onCancelButtonClicked = {
                        viewModel.resetOrder()
                        navController.popBackStack(SiparisVerScreen.Birinci.name, inclusive = false)
                    })
            }
        }

    }

}