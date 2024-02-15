package com.example.caesar_cipher_cryptography

import android.content.Context
import android.content.Intent
import android.graphics.Paint.Align
import android.text.Layout.Alignment
import android.widget.Switch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Cipher(viewModel: AppLogic = androidx.lifecycle.viewmodel.compose.viewModel()){
    val context = LocalContext.current
    var encrypt by remember { mutableStateOf(true) }

    Column( modifier = Modifier
        .padding(12.dp)) {
        Row (modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Enter text here to  ${if(encrypt){"Encrypt"} else { "Decrypt" } 
            }:", fontWeight = FontWeight(500), fontSize = 20.sp, modifier = Modifier.padding(top =8.dp) )

            Switch(
                checked = encrypt,
                onCheckedChange = {
                    encrypt = it
                },
                Modifier.padding(end = 12.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Black,
                    uncheckedThumbColor = Color.Green
                )

            )
        }
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


        Spacer(modifier = Modifier.padding(10.dp))
        Card(modifier = Modifier.fillMaxWidth()){
            Text(text = "Output text: ", Modifier.padding(12.dp) , fontWeight = FontWeight(700))
            Text(
                if(encrypt){
                    viewModel.encryptText()
                }
                else{
                    viewModel.decryptText()
                    },
                Modifier.padding(12.dp))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                Button(onClick = { shareContent(context, viewModel.encryptText()) }, Modifier.padding(12.dp)) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = null)
                }
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