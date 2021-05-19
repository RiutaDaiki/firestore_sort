package com.example.firestoresort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.add_button)
        val edit = findViewById<EditText>(R.id.editTextText)


        button.setOnClickListener{
            val storeContent = content(edit.text.toString(), Timestamp(System.currentTimeMillis()))
            db.collection("row items")
                .add(storeContent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = MyRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}