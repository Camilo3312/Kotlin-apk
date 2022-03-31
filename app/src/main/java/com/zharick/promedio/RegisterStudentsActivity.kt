package com.zharick.promedio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterStudentsActivity : AppCompatActivity() {
    val coursesStudent = mutableListOf<Courses>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_students)
        findViewById<Button>(R.id.btn_register_course).setOnClickListener {
            pushCourses()
        }
        var btn_register_student:Button = findViewById(R.id.btn_register_student)
        btn_register_student.setOnClickListener {
            pushStudent()
        }
    }

    fun pushCourses() {
        val course_nameS:EditText = findViewById(R.id.course_name)
        val gradeS:EditText = findViewById(R.id.grade)
        if(gradeS.text.toString().toInt() > 5 || gradeS.text.toString().toInt() < 0) {
            Toast.makeText(this, "No puede ingresar una nota mayor a 5 y menor a 0", Toast.LENGTH_LONG).show()
        } else {
            val courses = Courses(
                course_nameS.text.toString(),
                gradeS.text.toString().toInt()
            )
            coursesStudent.add(courses)

            course_nameS.setText("")
            gradeS.setText("")

            Toast.makeText(this, "Nota ${coursesStudent.size} registrada", Toast.LENGTH_LONG).show()

        }
    }

    fun pushStudent() {
        val documentS:EditText = findViewById(R.id.document)
        val fullnameS:EditText = findViewById(R.id.fullname)
        val ageS:EditText = findViewById(R.id.age)
        val phoneS:EditText = findViewById(R.id.phone)
        val locationS:EditText = findViewById(R.id.location)
        val new_student = Students(
            documentS.text.toString(),
            fullnameS.text.toString(),
            ageS.text.toString(),
            phoneS.text.toString(),
            locationS.text.toString(),
            coursesStudent
        )
        Registers.addStudent(new_student)

        val intent = Intent(this, ResultStudentActivity::class.java)
        intent.putExtra("last_student", Registers.lengthRegistersStudents())
        startActivity(intent)
    }
}