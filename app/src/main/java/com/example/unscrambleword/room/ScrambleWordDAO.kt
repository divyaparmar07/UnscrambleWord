package com.example.unscrambleword.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.unscrambleword.model.ScrambleWord

@Dao
interface ScrambleWordDAO {

    @Insert
    suspend fun insert(scrambleWord: ScrambleWord)

}