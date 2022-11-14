package com.ssd.study.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ssd.study.room.entity.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAllData()
}