package com.example.unscrambleword.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.unscrambleword.model.ScrambleWord
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ScrambleWord::class], version = 1)
abstract class ScrambleWordDatabase : RoomDatabase() {
    abstract fun getDao(): ScrambleWordDAO

    companion object {

        @Volatile
        private var INSTANCE: ScrambleWordDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ScrambleWordDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScrambleWordDatabase::class.java, "scramble_word_database"
                )
                    .build()

                INSTANCE = instance

                instance

            }
        }

    }

}