package com.lucascamarero.botonholamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    var pruebaField by remember { mutableStateOf("Prueba Field") }


    Column(// que caracterisiticas van a cumplir mis columnas
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // centra horizontalmente
        verticalArrangement = Arrangement.Top // empieza desde arriba
    ) {  // Codigo ve ventana que se encuentra dentro de las columnas

        OutlinedTextField(
            value = pruebaField,
            onValueChange = { newText -> pruebaField = newText },
            label = { Text("Prueba") },
            placeholder = { Text("ej") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Pulsa el botón")
        Button(onClick = { buttonText = action() }) {
            // Contenido del boton
            Text(buttonText)
        }
        Text(text = pruebaField)
    }
}

fun action(): String {
    return "PRUEBA"
}