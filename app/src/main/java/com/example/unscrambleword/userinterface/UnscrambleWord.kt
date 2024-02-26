package com.example.unscrambleword.userinterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscrambleword.GameViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscrambleword.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .size(width = 400.dp, height = 300.dp)
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                OutlinedTextField(
                    value = gameViewModel.editTextWord1,
                    onValueChange = { gameViewModel.textChanged(it) },
                    label = { Text(stringResource(R.string.enter_your_word)) }
                )

                Text(
                    text = gameUiState.scrambleWord,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 22.sp,

                    )
                OutlinedButton(onClick = { gameViewModel.submitButtonClicked() }) {
                    Text(text = "Submit")
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview() {
    GameScreen()
}