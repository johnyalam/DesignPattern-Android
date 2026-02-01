package fi.developer.designpattern_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.developer.basic_kotlin.NativeLib
import fi.developer.basic_kotlin.system.DeviceInformation
import fi.developer.designpattern_android.ui.theme.DesignPatternAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignPatternAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(10.dp)) {
        Text(
            text = DeviceInformation.from(LocalContext.current).androidVersion,
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            color = Color.Green,
            fontSize = 40.sp,
            lineHeight = 40.sp,
            fontStyle = FontStyle.Italic,
            
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignPatternAndroidTheme {
        Greeting()
    }
}