package fi.developer.designpattern_android.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoRow(text: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)){
        Row(modifier = Modifier.fillMaxWidth().padding( 8.dp)) {
            Text(text, style = MaterialTheme.typography.bodyMedium)
            Text(" : ", style = MaterialTheme.typography.bodyMedium)
            Text(value, style = MaterialTheme.typography.bodyMedium)
        }
    }
}