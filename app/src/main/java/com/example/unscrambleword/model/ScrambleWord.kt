package com.example.unscrambleword.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scramble_word")
class ScrambleWord(
    val word: String,
    val word1: String,
    val word2: String,
    val word3: String,
    val word4: String,
    val word5: String
) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}