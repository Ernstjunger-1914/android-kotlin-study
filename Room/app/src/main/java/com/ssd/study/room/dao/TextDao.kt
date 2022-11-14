package com.ssd.study.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ssd.study.room.entity.Text

@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData(): List<Text>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: Text)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}