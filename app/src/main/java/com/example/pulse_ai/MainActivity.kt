package com.example.pulse_ai

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.pulse_ai.ui.theme.AppTheme

private sealed class Screen {
    data object Onboarding : Screen()
    data object Registration : Screen()
    data object Login : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.Onboarding) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (val screen = currentScreen) {
                        is Screen.Onboarding -> OnboardingScreen(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
                            onRegisterClick = { currentScreen = Screen.Registration },
                            onLoginClick = { currentScreen = Screen.Login }
                        )
                        is Screen.Registration -> {
                            BackHandler { currentScreen = Screen.Onboarding }
                            RegistrationScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                onBack = { currentScreen = Screen.Onboarding },
                                onFinish = {
                                    startActivity(Intent(this, HowItWorksActivity::class.java))
                                    finish()
                                }
                            )
                        }
                        is Screen.Login -> {
                            BackHandler { currentScreen = Screen.Onboarding }
                            LoginScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                onBack = { currentScreen = Screen.Onboarding },
                                onLogin = {
                                    startActivity(Intent(this, HomeActivity::class.java))
                                    finish()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LogoCard()
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "“Pulse AI te ayuda a no\nolvidar lo importante”",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryRoundedButton(
                    text = "REGISTRARSE",
                    onClick = onRegisterClick
                )
                Spacer(modifier = Modifier.height(16.dp))
                PrimaryRoundedButton(
                    text = "INGRESAR",
                    onClick = onLoginClick
                )
            }
        }
    }
}

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onFinish: () -> Unit = {},
) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var repeatPassword by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            LogoCard()
            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                RegistrationField(
                    label = "Nombre Completo",
                    value = fullName,
                    onValueChange = { fullName = it },
                    onClear = { fullName = "" },
                    keyboardOptions = KeyboardOptions.Default
                )
                RegistrationField(
                    label = "e-mail",
                    value = email,
                    onValueChange = { email = it },
                    onClear = { email = "" },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                RegistrationField(
                    label = "Contraseña",
                    value = password,
                    onValueChange = { password = it },
                    onClear = { password = "" },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                RegistrationField(
                    label = "Repite tu contraseña",
                    value = repeatPassword,
                    onValueChange = { repeatPassword = it },
                    onClear = { repeatPassword = "" },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            PrimaryRoundedButton(
                text = "FINALIZAR",
                onClick = {
                    focusManager.clearFocus()
                    // TODO: validar y guardar registro
                    onFinish()
                }
            )
        }
    }
}

@Composable
private fun RegistrationField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Text(
                        text = "×",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    )
}

private const val PULSE_ICON_VIEWPORT = 512f
private val PulseIconBackground = Color(0xFF0F172A)
private val PulseGradientStart = Color(0xFF6A5CFF)
private val PulseGradientEnd = Color(0xFF00D4FF)

@Composable
fun LogoCard() {
    Surface(
        shape = RoundedCornerShape(32.dp),
        color = PulseIconBackground
    ) {
        Canvas(modifier = Modifier.size(160.dp)) {
            val scale = size.minDimension / PULSE_ICON_VIEWPORT
            scale(scale, scale) {
                // Pulse line path: M90 260 L170 260 L210 170 L260 350 L310 200 L350 260 L420 260
                val path = Path().apply {
                    moveTo(90f, 260f)
                    lineTo(170f, 260f)
                    lineTo(210f, 170f)
                    lineTo(260f, 350f)
                    lineTo(310f, 200f)
                    lineTo(350f, 260f)
                    lineTo(420f, 260f)
                }
                drawPath(
                    path = path,
                    brush = Brush.linearGradient(
                        start = Offset(0f, 0f),
                        end = Offset(PULSE_ICON_VIEWPORT, PULSE_ICON_VIEWPORT),
                        colors = listOf(PulseGradientStart, PulseGradientEnd)
                    ),
                    style = Stroke(
                        width = 28f,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )
            }
        }
    }
}

@Composable
fun PrimaryRoundedButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    AppTheme {
        OnboardingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    AppTheme {
        RegistrationScreen()
    }
}