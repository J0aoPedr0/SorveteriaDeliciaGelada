package com.example.sorveteriadelciagelada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sorveteriadelciagelada.ui.theme.SorveteriaDelíciaGeladaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SorveteriaDelíciaGeladaTheme {
                Navigation()
            }
        }
    }
}
@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "") {

        composable("screen_A"){
            HomeScreen(navController = navController)
        }
        composable("screen_B"){
            ItemsScreen(navController = navController)
        }
    }
}
