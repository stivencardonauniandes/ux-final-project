package com.example.pulse_ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pulse_ai.ui.theme.AppTheme

class AlarmPreviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val title = intent.getStringExtra(EXTRA_TITLE).orEmpty()
        val description = intent.getStringExtra(EXTRA_DESCRIPTION).orEmpty()
        val time = intent.getStringExtra(EXTRA_TIME).orEmpty()

        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AlarmPreviewScreen(
                        initialTitle = title,
                        initialDescription = description,
                        initialTime = time,
                        onConfirm = { _, _, _ ->
                            // TODO: guardar cambios si se necesita
                            finish()
                        },
                        onDiscard = { finish() },
                    )
                }
            }
        }
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_TIME = "extra_time"
    }
}
