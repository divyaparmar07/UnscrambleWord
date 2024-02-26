package com.example.unscrambleword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unscrambleword.ui.theme.UnscrambleWordTheme
import com.example.unscrambleword.userinterface.GameScreen
import com.example.unscrambleword.userinterface.GameScreen1
import com.example.unscrambleword.userinterface.GameScreen2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            GameScreen()
            GameScreen2()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnscrambleWordTheme {
        GameScreen()
//        Greeting("Android")
    }
}