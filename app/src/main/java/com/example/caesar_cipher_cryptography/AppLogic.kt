package com.example.caesar_cipher_cryptography

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppLogic :ViewModel(){
    var notCipher by mutableStateOf("")


    fun convert() : String {
        val ascii = notCipher.map { it.code + 3 }
        return ascii.map {
            if (it == 35) {
                " "
            } else if (it == 123) {
                "a"
            } else if (it == 124) {
                "b"
            } else if (it == 125) {
                "c"
            } else if (it == 91) {
                "A"
            } else if (it == 92) {
                "B"
            } else if (it == 93) {
                "C"
            }
            else if (it == 49) {
            "."
        }else {
                it.toChar().toString()
            }
        }.joinToString("")
    }

}