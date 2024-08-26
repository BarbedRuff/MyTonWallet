package com.genss.mytonwallet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.genss.mytonwallet.R
import com.genss.mytonwallet.ui.theme.*
import com.genss.mytonwallet.ui.theme.MyTonWalletTheme
import com.genss.mytonwallet.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTonWalletTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .size(124.dp)
                                .padding(bottom = 24.dp),
                            painter = painterResource(R.drawable.crystal),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp),
                            text = "MyTonWallet",
                            style = Typography.bodyLarge
                        )
                        Text(
                            modifier = Modifier
                                .padding(bottom = 32.dp),
                            text = "Securely store and send crypto.",
                            style = Typography.bodyMedium
                        )
                        CreateWalletButton()
                        ImportExistingButton()
                    }
                }
            }
        }
    }

    @Composable
    fun CreateWalletButton() {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            contentPadding = PaddingValues(vertical = 13.dp, horizontal = 94.dp),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "Create New Wallet",
                color = White,
                style = Typography.labelMedium
            )
        }
    }

    @Composable
    fun ImportExistingButton() {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = White),
            contentPadding = PaddingValues(vertical = 13.dp, horizontal = 94.dp),
        ) {
            Text(
                text = "Import Existing Wallet",
                color = Blue,
                style = Typography.labelMedium
            )
        }
    }
}
