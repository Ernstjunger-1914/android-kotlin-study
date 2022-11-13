package com.ssd.study.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SQLiteHelper(this)

        val input = findViewById<EditText>(R.id.inputView)
        val insert = findViewById<Button>(R.id.insert)
        val select = findViewById<Button>(R.id.select)
        val delete = findViewById<Button>(R.id.delete)
        val result = findViewById<TextView>(R.id.result)

        insert.setOnClickListener {
            val inputText = input.text.toString()

            db.insert(inputText)
            input.setText("")
        }

        select.setOnClickListener {
            val arr = db.getAllData()
            result.text = arr.toString()
        }

        delete.setOnClickListener {
            db.deleteAll()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        db.close()
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}