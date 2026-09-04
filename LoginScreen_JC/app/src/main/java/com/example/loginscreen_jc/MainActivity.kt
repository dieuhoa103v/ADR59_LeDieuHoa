package com.example.loginscreen_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Vertical
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen_jc.ui.theme.LoginScreen_JCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen_JCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Greeting()
        InputField()
        LoginBtn()
        ForgotPassBtn(onClick = {})
    }

}

@Composable
fun ForgotPassBtn(onClick: () -> Unit) {
    Text(
        text = "Forgot Password?",
        color = MaterialTheme.colorScheme.secondary,
        style = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        ),
        modifier = Modifier.padding(top = 36.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun LoginBtn(
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xFF664E77)
) {
    FilledTonalButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.LightGray
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.padding(top = 24.dp)
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 18.sp
        )
    }
}

@Composable
fun InputField() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = {email = it},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            capitalization = KeyboardCapitalization.None,
            autoCorrectEnabled = false,
            imeAction = ImeAction.Done,
            platformImeOptions = null,
            showKeyboardOnFocus = null,
            hintLocales = null
        ),
        label = { Text("Email") },
        placeholder = {
            Text("Email")
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 20.dp)
    )


}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier.padding(bottom = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome back",
            style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding( bottom = 8.dp)
        )

        Text(
            text = "Sign in to continue",
            style = TextStyle(
                fontSize = 15.sp
            ),

        )
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen_JCTheme {
        LoginScreen()
    }
}