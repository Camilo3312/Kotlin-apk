package com.zharick.promedio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_show_register_students:Button = findViewById(R.id.btn_show_register_students)
        val btn_show_all_students:Button = findViewById(R.id.btn_show_all_students)
        val btn_show_help:Button = findViewById(R.id.btn_show_help)

        btn_show_register_students.setOnClickListener {
            var intent = Intent(this, RegisterStudentsActivity::class.java)
            startActivity(intent)
        }

        btn_show_all_students.setOnClickListener {
            var intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }
        btn_show_help.setOnClickListener {
            var intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }
}