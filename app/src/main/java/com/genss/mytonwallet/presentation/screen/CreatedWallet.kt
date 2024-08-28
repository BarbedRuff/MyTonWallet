package com.genss.mytonwallet.presentation.screen

import android.os.Build.VERSION.SDK_INT
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.genss.mytonwallet.R
import com.genss.mytonwallet.presentation.uikit.buttonText
import com.genss.mytonwallet.ui.theme.Blue
import com.genss.mytonwallet.ui.theme.Typography
import com.genss.mytonwallet.ui.theme.White

@Composable
fun Create(
    passcodeAction: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GifImage()
        Text(
            modifier = Modifier
                .padding(bottom = 12.dp),
            text = "Wallet created",
            style = Typography.bodyLarge
        )
        Text(
            modifier = Modifier
                .padding(bottom = 32.dp),
            text = "Create a passcode to protect it.",
            style = Typography.bodyMedium
        )
        SetUpPasscode(passcodeAction)
    }
}

@Composable
fun GifImage() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.firecracker).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier
            .size(124.dp)
            .padding(bottom = 24.dp),
    )
}

@Composable
fun SetUpPasscode(
    passcodeAction: () -> Unit,
) {
    Button(
        onClick = passcodeAction,
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
        contentPadding = PaddingValues(vertical = 13.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 48.dp, end = 48.dp)
    ) {
        buttonText(text = "Set Up Passcode", color = White)
    }
}