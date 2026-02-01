package fi.developer.designpattern_android.ui.screen

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fi.developer.designpattern_android.ui.components.InfoRow
import fi.developer.designpattern_android.ui.theme.DesignPatternAndroidTheme
import fi.developer.designpattern_android.viewmodel.HomeViewModel

@Composable
fun AboutScreen(navController: NavController,modifier: Modifier = Modifier,
               viewModel: HomeViewModel = HomeViewModel(LocalContext.current.applicationContext as Application)) {
    val deviceInfo by viewModel.deviceInfo.collectAsState()

    LazyColumn(modifier = modifier.fillMaxSize().background(Color.Blue).padding(16.dp)) {
        item { Text("Device About", style = MaterialTheme.typography.titleLarge) }
        item{ Spacer(modifier = Modifier.height(16.dp))}

        item { InfoRow("Manufacturer", deviceInfo.manufacturer) }
        item { InfoRow("Brand", deviceInfo.brand) }
        item { InfoRow("Model", deviceInfo.model) }
        item { InfoRow("Device", deviceInfo.device) }
        item { InfoRow("Product", deviceInfo.product) }
        item { InfoRow("Android Version", deviceInfo.androidVersion) }
        item { InfoRow("SDK Int", deviceInfo.sdkInt.toString()) }
        item { InfoRow("Hardware", deviceInfo.hardware) }
        item { InfoRow("Board", deviceInfo.board) }
        item { InfoRow("Device ID", deviceInfo.deviceId) }

        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { navController.popBackStack()}) {
                    Text("Back")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    DesignPatternAndroidTheme {
        val navController: NavController = NavController(LocalContext.current)
        HomeScreen(navController)
    }
}