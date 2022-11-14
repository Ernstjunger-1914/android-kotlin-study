package com.ssd.study.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.ssd.study.room.entity.Text
import com.ssd.study.room.db.TextDataBase
import com.ssd.study.room.entity.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var text: Text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = TextDataBase.getDataBase(this)
        val input = findViewById<EditText>(R.id.input)
        val insert = findViewById<Button>(R.id.insert)
        val select = findViewById<Button>(R.id.select)
        val delete = findViewById<Button>(R.id.delete)

        insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(Text(0, input.text.toString()))
                db.wordDao().insert(Word(0, input.text.toString()))
                input.setText("")
            }
        }

        select.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG, db.textDao().getAllData().toString())
                Log.d(TAG, db.wordDao().getAllData().toString())
            }
        }

        delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
                db.wordDao().deleteAllData()
            }
        }
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}