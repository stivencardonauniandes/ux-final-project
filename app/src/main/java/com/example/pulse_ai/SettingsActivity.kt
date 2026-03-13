package com.example.pulse_ai

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pulse_ai.ui.theme.AppTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SettingsScreen(
                        onBack = { finish() },
                        onIntegracionesClick = {
                            startActivity(Intent(this, IntegrationsActivity::class.java))
                        },
                        onCerrarSesionClick = {
                            startActivity(
                                Intent(this, MainActivity::class.java).apply {
                                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                }
                            )
                            finish()
                        },
                    )
                }
            }
        }
    }
}
