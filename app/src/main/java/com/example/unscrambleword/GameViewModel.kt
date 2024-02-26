package com.example.unscrambleword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscrambleword.model.ScrambleWord
import com.example.unscrambleword.viewmodel.UnscrambleWordViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private lateinit var unscrambleWordViewModel: UnscrambleWordViewModel

    private val _uiState = MutableStateFlow(DataViewState())
    val uiState = _uiState.asStateFlow()

    private var usedWords: MutableSet<String> = mutableSetOf()

    var editTextWord1 by mutableStateOf("")
        private set

    fun textChanged(text: String) {
        editTextWord1 = text
    }

//    fun insert(sw: ScrambleWord) = viewModelScope.launch(Dispatchers.IO){
//        repository.insert(sw)
//    }

    fun textChanged1(text: String) {
        editTextWord1 = text
        usedWords.add(text)
        val resultingString = findRepeatWords(editTextWord1)
        _uiState.value = _uiState.value.copy(scrambleWord = resultingString)
        val resultingString2 = findRepeatWords(resultingString)
        _uiState.value = _uiState.value.copy(scrambleWord2 = resultingString2)
        val resultingString3 = findRepeatWords(resultingString2)
        _uiState.value = _uiState.value.copy(scrambleWord3 = resultingString3)
        val resultingString4 = findRepeatWords(resultingString3)
        _uiState.value = _uiState.value.copy(scrambleWord4 = resultingString4)
        val resultingString5 = findRepeatWords(resultingString4)
        _uiState.value = _uiState.value.copy(scrambleWord5 = resultingString5)
        val resultingString6 = findRepeatWords(resultingString5)
        _uiState.value = _uiState.value.copy(scrambleWord6 = resultingString6)

        val sw = ScrambleWord(
            resultingString,
            resultingString2,
            resultingString3,
            resultingString4,
            resultingString5,
            resultingString6
        )
        unscrambleWordViewModel.insert(sw)
    }

    private fun findRepeatWords(text: String): String {
        var res = takeStringRandomly1(text)
        if (usedWords.contains(res)) {
            res = takeStringRandomly1(text)
        } else {
            usedWords.add(res)
        }
        return res
    }

    private fun takeStringRandomly1(word: String): String {
        val charArray = word.toCharArray()
        charArray.shuffle()
        val resultingString = charArray.joinToString(separator = "")
        _uiState.value = _uiState.value.copy(scrambleWord = resultingString)
        return resultingString
    }

    fun submitButtonClicked() {
        takeStringRandomly1(editTextWord1)
    }
}