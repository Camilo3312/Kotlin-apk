package com.zharick.promedio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ResultStudentActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_student)
        val fullnameS:TextView = findViewById(R.id.fullname)
        val stateS:TextView = findViewById(R.id.state_student)
        val coursesS:TextView = findViewById(R.id.courses)
        val averageS:TextView = findViewById(R.id.average)
        val recuperationS:TextView = findViewById(R.id.recuperation)
        val cardResultStudent:LinearLayout = findViewById(R.id.card_result_student)
        val pos_student = this.intent.extras?.getInt("last_student").toString().toInt()

        // Object student
        val student = Registers.registerStudent(pos_student)

        fullnameS.text = student.fullname
        val result_prom =  Students.calcGradeAverage(student.courses!!)

        if(Students.stateStudent(result_prom)) {
            stateS.text = "Pasaste el periodo"
            cardResultStudent.setBackgroundColor(Color.parseColor("#2D8523"))
        } else {

            stateS.text = "Perdiste el periodo"

            if(Students.recuperation(result_prom)) {
                recuperationS.text = "Usted puede recuperar"
                cardResultStudent.setBackgroundColor(Color.parseColor("#C68524"))
            }
            else {
                recuperationS.text = "No es posible recuperar"
                cardResultStudent.setBackgroundColor(Color.parseColor("#932323"))
            }
        }
        var all_courses = ""
        for (i in student.courses) {
            all_courses += "${i.name_course} ${i.grade}\n"
        }

        coursesS.text = all_courses
        averageS.text = "Su promedio fue de ${result_prom.toString()}"

        // println("${ student.document } ${ student.fullname } ${ student.phone } ${ student.courses } ")
    }
}