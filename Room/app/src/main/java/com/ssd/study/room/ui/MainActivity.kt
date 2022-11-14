package com.ssd.study.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssd.study.room.R
import com.ssd.study.room.entity.Text
import com.ssd.study.room.db.TextDataBase
import com.ssd.study.room.entity.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var text: Text
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.select()

        val db = TextDataBase.getDataBase(this)
        val input = findViewById<EditText>(R.id.input)
        val insert = findViewById<Button>(R.id.insert)
        val select = findViewById<Button>(R.id.select)
        val delete = findViewById<Button>(R.id.delete)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.getText.observe(this, Observer {
            val adapter = MainViewHolder(it)

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
        })

        insert.setOnClickListener {
            viewModel.insert(input.text.toString())
            input.setText("")
        }

        select.setOnClickListener {
            viewModel.select()
        }

        delete.setOnClickListener {
            viewModel.delete()
        }
    }

    companion object {
        const val TAG: String = "MainActivity"
    }

}