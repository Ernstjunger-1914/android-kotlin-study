package com.ssd.study.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ssd.study.room.dao.TextDao
import com.ssd.study.room.dao.WordDao
import com.ssd.study.room.entity.Text
import com.ssd.study.room.entity.Word

@Database(entities = [Text::class, Word::class], version = 2)
abstract class TextDataBase : RoomDatabase() {

    abstract fun textDao(): TextDao
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: TextDataBase? = null

        fun getDataBase(
            context: Context
        ): TextDataBase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                TextDataBase::class.java,
                "text_database"
            )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            instance
        }
    }

}