package com.zharick.promedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        findViewById<TextView>(R.id.all_students).text = "${Registers.lengthRegistersStudents() + 1}"
        findViewById<TextView>(R.id.approved).text = "${Registers.valueApprovedStudents().toString()}"
        findViewById<TextView>(R.id.recovery).text = "${Registers.valueRecuperationStudents()}"
        findViewById<TextView>(R.id.falied).text = "${(Registers.lengthRegistersStudents() + 1) - Registers.valueApprovedStudents()}"
    }
}