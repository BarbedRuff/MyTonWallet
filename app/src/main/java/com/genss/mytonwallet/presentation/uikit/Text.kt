package com.genss.mytonwallet.presentation.uikit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.genss.mytonwallet.ui.theme.Typography

@Composable
fun buttonText(
    text: String,
    color: Color
){
    Text(
        text = text,
        color = color,
        style = Typography.labelMedium
    )
}