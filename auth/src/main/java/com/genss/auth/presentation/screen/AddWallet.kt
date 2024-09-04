package com.genss.auth.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.genss.auth.theme.Blue
import com.genss.auth.theme.White
import com.genss.auth.theme.Typography
import com.genss.auth.R

@Composable
fun CreateWalletScreen(
    createWalletAction: () -> Unit,
    importExistingAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
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
        CreateWalletButton(createWalletAction)
        ImportExistingButton(importExistingAction)
    }
}

@Composable
fun CreateWalletButton(
    createWalletAction: () -> Unit,
) {
    Button(
        onClick = createWalletAction,
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
        contentPadding = PaddingValues(vertical = 13.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 46.dp, end = 46.dp)
    ) {
        Text(
            text = "Create New Wallet",
            color = White,
            style = Typography.labelMedium
        )
    }
}

@Composable
fun ImportExistingButton(
    importExistingAction: () -> Unit
) {
    Button(
        onClick = importExistingAction,
        colors = ButtonDefaults.buttonColors(containerColor = White),
        contentPadding = PaddingValues(vertical = 13.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 46.dp, end = 46.dp)
    ) {
        Text(
            text = "Import Existing Wallet",
            color = Blue,
            style = Typography.labelMedium
        )
    }
}