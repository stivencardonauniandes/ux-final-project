package com.example.pulse_ai

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pulse_ai.ui.theme.AppTheme

private val modalBackgroundGreen = Color(0xFFC8E6C9)
private val acceptButtonGreen = Color(0xFF2E7D32)

data class IntegrationItem(
    val name: String,
    val iconChar: String,
)

private val defaultIntegrations = listOf(
    IntegrationItem("Google Calendar", "📅"),
    IntegrationItem("Whats App", "📱"),
    IntegrationItem("Apple Calendar", "♥"),
    IntegrationItem("Gmail", "✉"),
)

@Composable
fun IntegrationsScreen(
    modifier: Modifier = Modifier,
    userName: String = "Nicolas Mora",
    userEmail: String = "doctor.morita@terramoda.com",
    integrations: List<IntegrationItem> = defaultIntegrations,
    onBack: () -> Unit = {},
    onConnectClick: (IntegrationItem) -> Unit = {},
) {
    var showSuccessModal by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
        ) {
        // Barra superior: flecha atrás + título
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 48.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBack) {
                Text(
                    text = "←",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            Text(
                text = "Integraciones",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
        ) {
            // Sección de perfil
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                Column {
                    Text(
                        text = userName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    Text(
                        text = userEmail,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Lista de integraciones
            integrations.forEach { item ->
                IntegrationListItem(
                    item = item,
                    onConnectClick = {
                        onConnectClick(item)
                        showSuccessModal = true
                    },
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
        }

        if (showSuccessModal) {
            Dialog(onDismissRequest = { showSuccessModal = false }) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = modalBackgroundGreen,
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Integracion realizada con exito!",
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
                                onClick = { showSuccessModal = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = acceptButtonGreen,
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
private fun IntegrationListItem(
    item: IntegrationItem,
    onConnectClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceContainerLow,
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = item.iconChar,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        Row(
            modifier = Modifier.clickable(onClick = onConnectClick),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = "conectar",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "›",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
private fun IntegrationsScreenPreview() {
    AppTheme {
        IntegrationsScreen()
    }
}
