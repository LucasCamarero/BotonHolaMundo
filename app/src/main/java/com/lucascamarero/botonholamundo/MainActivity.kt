// Autor: Lucas Camarero

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
    var pruebaField by remember { mutableStateOf("0") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = pruebaField,
            onValueChange = { newText -> pruebaField = newText },
            label = { Text("Introduce un número") },
            placeholder = { Text("ej") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "Comprueba si es un número primo")
        Button(onClick = { action(pruebaField) }) {
            // Contenido del boton
            Text("Comprobar")
        }
        Text(text = pruebaField)
    }
}

fun action(numero: String) {

}