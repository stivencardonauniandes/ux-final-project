package com.example.pulse_ai

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pulse_ai.ui.theme.AppTheme

private val discardButtonColor = Color(0xFF904A49)
private val modalDiscardBackground = Color(0xFFF8BBD9)
private val modalDiscardButton = Color(0xFF904A49)
private val modalConfirmBackground = Color(0xFFC8E6C9)
private val modalConfirmButton = Color(0xFF2E7D32)

@Composable
fun AlarmPreviewScreen(
    modifier: Modifier = Modifier,
    initialTitle: String = "",
    initialDescription: String = "",
    initialTime: String = "",
    onConfirm: (String, String, String) -> Unit = { _, _, _ -> },
    onDiscard: () -> Unit = {},
) {
    var title by rememberSaveable(initialTitle) { mutableStateOf(initialTitle) }
    var description by rememberSaveable(initialDescription) { mutableStateOf(initialDescription) }
    var time by rememberSaveable(initialTime) { mutableStateOf(initialTime) }
    var showDiscardModal by remember { mutableStateOf(false) }
    var showConfirmModal by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(
            text = "VISTA PREVIA",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Spacer(modifier = Modifier.height(32.dp))

        PreviewField(
            label = "Titulo",
            value = title,
            onValueChange = { title = it },
        )
        Spacer(modifier = Modifier.height(20.dp))
        PreviewField(
            label = "Descripcion",
            value = description,
            onValueChange = { description = it },
        )
        Spacer(modifier = Modifier.height(20.dp))
        PreviewField(
            label = "Hora",
            value = time,
            onValueChange = { time = it },
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { showConfirmModal = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        ) {
            Text(
                text = "CONFIRMAR",
                style = MaterialTheme.typography.titleMedium,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showDiscardModal = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = discardButtonColor,
                contentColor = Color.White,
            ),
        ) {
            Text(
                text = "DESCARTAR",
                style = MaterialTheme.typography.titleMedium,
            )
        }
        }

        if (showDiscardModal) {
            Dialog(onDismissRequest = { }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = modalDiscardBackground,
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "La alarma ha sido descartada",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            Button(
                                onClick = {
                                    showDiscardModal = false
                                    onDiscard()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = modalDiscardButton,
                                    contentColor = Color.White,
                                ),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                                Text("Aceptar")
                            }
                        }
                    }
                }
            }
        }

        if (showConfirmModal) {
            Dialog(onDismissRequest = { }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = modalConfirmBackground,
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Ajuste de alarma confirmada",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            Button(
                                onClick = {
                                    showConfirmModal = false
                                    onConfirm(title, description, time)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = modalConfirmButton,
                                    contentColor = Color.White,
                                ),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                                Text("Aceptar")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PreviewField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            ),
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(onClick = { onValueChange("") }) {
                        Text(
                            text = "✕",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmPreviewScreenPreview() {
    AppTheme {
        AlarmPreviewScreen(
            initialTitle = "Legales",
            initialDescription = "Llamar abogado (doctor sanchez)",
            initialTime = "07:00 PM",
        )
    }
}
