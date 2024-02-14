package com.example.caesar_cipher_cryptography

import android.content.Context
import android.content.Intent
import android.graphics.Paint.Align
import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Cipher(viewModel: AppLogic = androidx.lifecycle.viewmodel.compose.viewModel()){
    val context = LocalContext.current
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {
        Text(text = "Enter Text here to decode:", fontWeight = FontWeight(500) )
        TextField(
            value = viewModel.notCipher,
            onValueChange = {viewModel.notCipher=it},
            label = { Text(text = "Your Message")},
            maxLines = 5,
            modifier = androidx.compose.ui.Modifier
                .size(365.dp, 150.dp)
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            )
        Spacer(modifier = Modifier.padding(30.dp))
        Card(modifier = Modifier.fillMaxSize()){
            Text(text = "Your cipher text: ", Modifier.padding(12.dp) , fontWeight = FontWeight(700))
            Text(text=viewModel.convert())
            Button(onClick = { shareContent(context, viewModel.convert()) }) {
               Icon(imageVector =  Icons.Filled.Share, contentDescription = null)
                Modifier.align
            }
        }


    }
}
private fun shareContent(context: Context, text: String) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }


    context.startActivity(Intent.createChooser(sendIntent, null))
}