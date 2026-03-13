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

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(
                        onSuggestedAlarmsClick = {
                            startActivity(Intent(this, SuggestedAlarmsActivity::class.java))
                        },
                        onSettingsClick = {
                            startActivity(Intent(this, SettingsActivity::class.java))
                        },
                        onAlarmAdjustClick = { alarm ->
                            startActivity(
                                Intent(this, AlarmPreviewActivity::class.java).apply {
                                    putExtra(AlarmPreviewActivity.EXTRA_TITLE, alarm.title)
                                    putExtra(AlarmPreviewActivity.EXTRA_DESCRIPTION, alarm.description)
                                    putExtra(AlarmPreviewActivity.EXTRA_TIME, alarm.time)
                                }
                            )
                        },
                        onFabClick = { /* TODO */ },
                    )
                }
            }
        }
    }
}
