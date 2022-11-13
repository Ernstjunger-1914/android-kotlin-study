package com.ssd.study.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "sample.db"
        const val TABLE_NAME = "sample_table"

        const val ID = "id"
        const val TITLE = "title"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_ENTRIES = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY,$TITLE TEXT)"

        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insert(data: String) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(TITLE, data)
        }

        db.insert(TABLE_NAME, null, values)
    }

    fun getAllData(): ArrayList<String> {
        val arr = ArrayList<String>()
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        with(cursor) {
            while (moveToNext()) {
                arr.add(getString(1))
            }
        }
        return arr
    }

    fun deleteAll() {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
    }

}