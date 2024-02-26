package com.example.unscrambleword.repository

import androidx.annotation.WorkerThread
import com.example.unscrambleword.model.ScrambleWord
import com.example.unscrambleword.room.ScrambleWordDAO

class ScrambleWordRepository(private val scrambleWord: ScrambleWordDAO) {

    @WorkerThread
    suspend fun insert(sw: ScrambleWord) {
        scrambleWord.insert(sw)
    }

}