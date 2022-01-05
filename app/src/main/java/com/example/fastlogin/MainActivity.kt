package com.example.fastlogin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

//private val vm = MainViewModel()

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinLogin()
        }
    }
}

@Composable
private fun PinButton(digit: Int, clickEvent: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
//                .background(Color(0xFFB0B0B0), shape = CircleShape)
            //.background(Color.Transparent, shape = CircleShape)
            .border(1.dp, Color(0xFFB0B0B0), shape = CircleShape)
            .layout { measurable, constraints ->
                // Measure the composable
                val placeable = measurable.measure(constraints)

                //get the current max dimension to assign width=height
                val currentHeight = placeable.height
                var heightCircle = currentHeight
                if (placeable.width > heightCircle)
                    heightCircle = placeable.width

                //assign the dimension and the center position
                layout(heightCircle, heightCircle) {
                    // Where the composable gets placed
                    placeable.placeRelative(x = 0, y = (heightCircle - currentHeight) / 2)
                }
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                role = Role.Button,
                indication = rememberRipple(
                    bounded = true,
                    radius = 36.dp,
                    color = Color.Green
                ),
                onClick = clickEvent
            )
    ) {
        Text(
            text = digit.toString(),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(24.dp)
                .defaultMinSize(24.dp) //Use a min size for short text.
        )
    }
}

@Composable
private fun PinLogin() {
    var enteredPin1 by remember { mutableStateOf("") }
    var enteredPin2 by remember { mutableStateOf("") }
    var enteredPin3 by remember { mutableStateOf("") }
    var enteredPin4 by remember { mutableStateOf("") }
    var enteredPin5 by remember { mutableStateOf("") }
    var enteredPin6 by remember { mutableStateOf("") }
    var enteredPin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val visualTransformation: VisualTransformation by remember {
//            mutableStateOf(PasswordVisualTransformation())
            mutableStateOf(VisualTransformation.None)
        }

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisAlignment = FlowMainAxisAlignment.Center
        ) {
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin1,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin2,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin3,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin4,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin5,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                value = enteredPin6,
                onValueChange = {},
                modifier = Modifier.width(48.dp),
                readOnly = true,
                enabled = false,
                visualTransformation = visualTransformation
            )
        }
//        Spacer(modifier = Modifier.size(8.dp))
//        Text(text = "Görüntülə",
//            modifier = Modifier.pointerInput(Unit) {
//                detectTapGestures(
//                    onLongPress = {
//                        visualTransformation =
//                            if (visualTransformation == VisualTransformation.None)
//                                PasswordVisualTransformation()
//                            else
//                                VisualTransformation.None
//                    }
//                )
//            }
//        )

        Spacer(modifier = Modifier.size(24.dp))

        fun setPin(digit: Int) {
            val digitS = digit.toString()
            when (enteredPin.length) {
                0 -> {
                    enteredPin += digitS
                    enteredPin1 = digitS
                }
                1 -> {
                    enteredPin += digitS
                    enteredPin2 = digitS
                }
                2 -> {
                    enteredPin += digitS
                    enteredPin3 = digitS
                }
                3 -> {
                    enteredPin += digitS
                    enteredPin4 = digitS
                }
                4 -> {
                    enteredPin += digitS
                    enteredPin5 = digitS
                }
                5 -> {
                    enteredPin += digitS
                    enteredPin6 = digitS
                    // TODO: everything is OK, show verification
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PinButton(1) { setPin(digit = 1) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(2) { setPin(digit = 2) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(3) { setPin(digit = 3) }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PinButton(4) { setPin(digit = 4) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(5) { setPin(digit = 5) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(6) { setPin(digit = 6) }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PinButton(7) { setPin(digit = 7) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(8) { setPin(digit = 8) }
            Spacer(modifier = Modifier.size(32.dp))
            PinButton(9) { setPin(digit = 9) }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val activity = LocalContext.current as MainActivity
            IconButton(onClick = { biometricLogin(activity) }) {
                Image(
                    imageVector = Icons.Default.Fingerprint, contentDescription = "fingerprint"
                )
            }
            Spacer(modifier = Modifier.size(44.dp))
            PinButton(0) { setPin(digit = 0) }
            Spacer(modifier = Modifier.size(44.dp))
            IconButton(onClick = {
                when (enteredPin.length) {
                    1 -> enteredPin1 = ""
                    2 -> enteredPin2 = ""
                    3 -> enteredPin3 = ""
                    4 -> enteredPin4 = ""
                    5 -> enteredPin5 = ""
                    6 -> enteredPin6 = ""
                }
                enteredPin = enteredPin.dropLast(1)
            }) {
                Image(
                    imageVector = Icons.Default.Backspace, contentDescription = "delete"
                )
            }
        }
    }
}

private fun biometricLogin(activity: MainActivity) {
    BiometricPrompt(
        activity,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                println(result.authenticationType)
            }

            override fun onAuthenticationFailed() {
                println("failed amk")
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                println("errorCode: $errorCode")
                println(errString.toString())
            }
        }).authenticate(
        BiometricPrompt.PromptInfo.Builder()
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
            .setTitle("this is title")
            .setDescription("this is description")
            .setSubtitle("this is subtitle")
            .setNegativeButtonText("log out")
            .build()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PinLogin()
}