package com.genss.auth.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.genss.auth.R
import com.genss.auth.theme.Blue
import com.genss.auth.theme.Gray
import com.genss.auth.theme.Typography

@Composable
fun Wallet() {
    Scaffold(
        topBar = {
            TopBar({},{})
        }
    ) { paddingValues ->
        WalletScreen(paddingValues = paddingValues)
    }
}

@Composable
fun TopBar(
    scanAction: () -> Unit,
    settingsAction: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = settingsAction,
            modifier = Modifier
                .padding(start = 16.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(R.drawable.settings),
                contentDescription = null
            )

        }
        IconButton(
            onClick = scanAction,
            modifier = Modifier
                .padding(end = 16.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(R.drawable.scan),
                contentDescription = null
            )
        }
    }
}

@Composable
fun WalletScreen(
    paddingValues: PaddingValues
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = "MyTonWallet",
            style = Typography.headlineMedium,
            color = Gray,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            text = "$12 345.67",
            style = Typography.labelLarge,
            textAlign = TextAlign.Center
        )
        ActionButtons()
    }
}

@Composable
fun ActionButtons(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ){
        ButtonRegular(
            drawableRes = R.drawable.add,
            {},
            "Add",
            modifier = Modifier.weight(1f)
        )
        ButtonRegular(
            drawableRes = R.drawable.send,
            {},
            "Send",
            modifier = Modifier.weight(1f)
        )
        ButtonRegular(
            drawableRes = R.drawable.earn,
            {},
            "Earn",
            modifier = Modifier.weight(1f)
        )
        ButtonRegular(
            drawableRes = R.drawable.swap,
            {},
            "Swap",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ButtonRegular(
    drawableRes: Int,
    action: () -> Unit,
    buttonText: String,
    modifier: Modifier = Modifier
){
    Button(
        onClick = action,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(bottom = 4.dp),
                tint = Blue,
                painter = painterResource(drawableRes),
                contentDescription = null
            )
            Text(
                text = buttonText,
                style = Typography.bodyMedium,
                color = Blue,
                textAlign = TextAlign.Center,
                letterSpacing = 0.15.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}