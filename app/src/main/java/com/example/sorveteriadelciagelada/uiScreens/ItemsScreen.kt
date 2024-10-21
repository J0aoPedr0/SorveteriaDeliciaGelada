package com.example.sorveteriadelciagelada.uiScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sorveteriadelciagelada.CardInfo

@Composable
fun ItemsScreen(userName: String?, navController: NavHostController, cardInfo: CardInfo) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
        ) {
            Text(
                "Olá $userName!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .height(30.dp),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.cardElevation(24.dp)
            ) {
                Text(text =cardInfo.product)
                val list = listOf(
                    CardInfo("Bola de sorvete"),
                    CardInfo("Picolé comum"),
                    CardInfo("Picolé de cobertura"),
                    CardInfo("Pote de 100 ml"),
                    CardInfo("Pote de 200 ml"),
                    CardInfo("Pote de 500 ml"),
                    CardInfo("Pote de 1 litro")
                )


                LazyColumn {
                    items(list) {
                        Text(text = it.toString())
                    }
                }
            }
        }

    }

}
