package com.example.sorveteriadelciagelada.uiScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sorveteriadelciagelada.R
import com.example.sorveteriadelciagelada.ScreensHome

@Composable
fun HomeScreen(navController: NavHostController) {
    var textName by remember {
        mutableStateOf("")}
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_red)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Olá, qual o seu nome?",
            style = TextStyle(
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic
            )
        )

        OutlinedTextField(
            value = textName,
            onValueChange = { text -> textName = text
            },
            label = { Text(text = "Nome:") },
            placeholder = { Text(text = "Nome:") },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            modifier = Modifier
                .background(Color.White)
        )
        Button(
            onClick = {
                if (textName.isBlank()) Toast.makeText(context, "Coloque um nome!",
                    Toast.LENGTH_SHORT).show()
                else{
                    navController.navigate(ScreensHome.ItemsScreen + "/$textName")
                }
                      },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier
                .padding(top = 36.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Salvar",
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}
