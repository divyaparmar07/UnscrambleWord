package com.example.unscrambleword.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unscrambleword.model.ScrambleWord
import com.example.unscrambleword.repository.ScrambleWordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnscrambleWordViewModel(private val repository: ScrambleWordRepository) : ViewModel() {

    fun insert(sw: ScrambleWord) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(sw)
    }

}