@file:OptIn(ExperimentalMaterial3Api::class)

package com.genss.mytonwallet.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.genss.mytonwallet.presentation.uikit.buttonText
import com.genss.mytonwallet.ui.theme.Blue
import com.genss.mytonwallet.ui.theme.Gray
import com.genss.mytonwallet.ui.theme.LightGray
import com.genss.mytonwallet.ui.theme.RedError
import com.genss.mytonwallet.ui.theme.Typography
import com.genss.mytonwallet.ui.theme.White

@Composable
fun ImportWallet(backAction: () -> Unit) {
    val topBarVisible = remember { mutableStateOf(false) }
    val scrollState = rememberLazyListState()
    LaunchedEffect(scrollState.firstVisibleItemIndex) {
        topBarVisible.value = scrollState.firstVisibleItemIndex > 0
    }
    Scaffold(
        topBar = {
            NavigationBar(backAction, topBarVisible)
        }
    ) { paddings ->
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .padding(paddingValues = paddings)
                .fillMaxSize()
        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    text = "Import wallet",
                    textAlign = TextAlign.Center,
                    style = Typography.bodyLarge
                )
            }
            item{
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    text = "You can restore access to your wallet by\n entering the 24 secret words that you wrote\n down when creating the wallet.",
                    textAlign = TextAlign.Center,
                    style = Typography.bodyMedium
                )
            }
            items(24) { index ->
                TextFieldWithLeadingNumber(
                    index + 1,
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = if (index != 23) 16.dp else 24.dp,
                            start = 48.dp,
                            end = 48.dp
                        )
                )
            }
            item {
                ContinueButton({})
            }
        }
    }
}


@Composable
fun ContinueButton(
    createWalletAction: () -> Unit,
) {
    Button(
        onClick = createWalletAction,
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
        contentPadding = PaddingValues(vertical = 13.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp, start = 48.dp, end = 48.dp)
    ) {
        buttonText(text = "Continue", color = White)
    }
}

@Composable
fun NavigationBar(backAction: () -> Unit, topBarVisible: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .padding(vertical = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = backAction,
            colors = IconButtonDefaults.iconButtonColors(contentColor = Gray)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
            )
        }
        if(topBarVisible.value)
            Text(
                text = "Import wallet",
                style = Typography.headlineMedium
            )
    }
}

@Composable
fun TextFieldWithLeadingNumber(
    index: Int,
    modifier: Modifier
) {
    var text = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        modifier = modifier,
        value = text.value,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        onValueChange = {
            text.value = it
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = LightGray,
            errorTextColor = RedError,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = Typography.bodyMedium,
        leadingIcon = {
            Text(
                text = index.toString(),
                color = Gray,
                style = Typography.bodyMedium
            )
        }
    )
}
