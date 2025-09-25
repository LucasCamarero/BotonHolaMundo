// Autor: Lucas Camarero

package com.lucascamarero.botonholamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucascamarero.botonholamundo.ui.theme.BotonHolaMundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotonHolaMundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ventanaHola(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ventanaHola(modifier: Modifier = Modifier) {
    var buttonText by remember { mutableStateOf("OK") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Pulsa el botón")
        Button(onClick = { buttonText = action(buttonText) }) {
            Text(buttonText)
        }
    }
}

fun action(variable: String): String {
    if (variable == "OK") {
        return "HOLA MUNDO"
    } else {
        return "OK"
    }
}