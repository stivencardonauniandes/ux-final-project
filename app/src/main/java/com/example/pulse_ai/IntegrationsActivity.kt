package com.example.pulse_ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pulse_ai.ui.theme.AppTheme

class IntegrationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    IntegrationsScreen(
                        onBack = { finish() },
                        onConnectClick = { /* TODO: abrir flujo de conexión */ },
                    )
                }
            }
        }
    }
}
