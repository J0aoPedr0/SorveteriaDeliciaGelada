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
import com.example.sorveteriadelciagelada.uiScreens.HomeScreen
import com.example.sorveteriadelciagelada.uiScreens.ItemsScreen

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
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ScreensHome.homeScreen
    ) {

        composable(ScreensHome.homeScreen) {
            HomeScreen(navController = navController)
        }

        composable(ScreensHome.ItemsScreen + "/{textName}") {
            val userName = it.arguments?.getString("textName")
            ItemsScreen(userName, navController = navController, cardInfo = CardInfo(""))

        }

    }

}


