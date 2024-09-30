package com.maopaa.randomcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maopaa.randomcolor.ui.theme.RandomColorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomColorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), // fill the entire screen
                    color = MaterialTheme.colorScheme.background
                ) {
                    var currentColor: Color by remember { mutableStateOf(Color.Black) }

                    Column(
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                    ) {
                        // Space between the top of the screen and the box
                        ColorDisplay(color = currentColor)
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(onClick = { currentColor = generateRandomColor() }) {
                            Text(text = "Generate a new Color")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorDisplay(color: Color) {
    Column(
        modifier = Modifier.background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp).padding(top = 16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(270.dp)
                .background(color = color, shape = RoundedCornerShape(10.dp))
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "RGB: (${(color.red * 255).toInt()}, ${(color.green * 255).toInt()}, ${(color.blue * 255).toInt()})"
        )
    }
}

/**
 * Fun: Generate a random color
 * @return Color
 */
private fun generateRandomColor(): Color {
    return Color(
        red = Random.nextInt(0, 255),
        green = Random.nextInt(0, 255),
        blue = Random.nextInt(0, 255)
    )
}