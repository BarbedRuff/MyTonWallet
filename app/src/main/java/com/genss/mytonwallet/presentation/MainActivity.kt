package com.genss.mytonwallet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.genss.mytonwallet.presentation.screen.Create
import com.genss.mytonwallet.presentation.screen.CreateWalletScreen
import com.genss.mytonwallet.presentation.screen.ImportWallet
import com.genss.mytonwallet.ui.theme.MyTonWalletTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTonWalletTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    navController = rememberNavController()
                    NavHost(
                        modifier = Modifier
                            .padding(innerPadding),
                        navController = navController,
                        startDestination = "wallet"
                    ) {
                        composable("wallet") {
                            CreateWalletScreen(
                                { navController.navigate("createWallet") },
                                { navController.navigate("importWallet") }
                            )
                        }
                        composable("createWallet") {
                            Create(
                                {}
                            )
                        }
                        composable("importWallet"){
                            ImportWallet { navController.popBackStack() }
                        }
                    }
                }
            }
        }
    }
}
