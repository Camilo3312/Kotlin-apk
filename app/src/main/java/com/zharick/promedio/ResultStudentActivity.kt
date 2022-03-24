package com.zharick.promedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
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
        val pos_student = this.intent.extras?.getInt("last_student").toString().toInt()

        // Object student
        val student = Registers.registerStudent(pos_student)

        fullnameS.text = student.fullname
        val result_prom =  Students.calcGradeAverage(student.courses!!)

        if(Students.stateStudent(result_prom)) {
            stateS.text = "Pasaste el periodo"
        } else {
            stateS.text = "Perdiste el periodo"
            if(Students.recuperation(result_prom)) {
                recuperationS.text = "Usted puede recuperar"
            }
            else {
                recuperationS.text = "No es posible recuperar"
            }
        }
        var all_courses = ""
        for (i in student.courses) {
            all_courses += "${i.name_course} ${i.grade}\n"
        }

        coursesS.text = all_courses
        averageS.text = result_prom.toString()

        // println("${ student.document } ${ student.fullname } ${ student.phone } ${ student.courses } ")
    }
}