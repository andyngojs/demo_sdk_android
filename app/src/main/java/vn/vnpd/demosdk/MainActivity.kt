package vn.vnpd.demosdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.vnpd.demosdk.ui.theme.DemosdkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemosdkTheme {
                NavigationBar(modifier = Modifier.padding(top = 0.dp).height(100.dp), containerColor = Color.Yellow) {
                    Text("Navigation Bar")
                }
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(top = 40.dp)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GreetingPreview() {
    DemosdkTheme {
        NavigationBar(modifier = Modifier.padding(top = 0.dp).height(60.dp), containerColor = Color.Yellow) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "back", modifier = Modifier.padding(start = 14.dp, end = 10.dp))
            Text("Demo SDK", fontSize = 25.sp)
        }
        Greeting("Dongnb ndddd", Modifier.padding(top = 70.dp))
    }
}
