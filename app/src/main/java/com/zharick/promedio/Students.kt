package com.zharick.promedio

import java.io.Serializable

class Students (document_:String, fullname_:String, age_:String, phone_:String, location_:String, courses_:MutableList<Courses>?) {
    val document:String = document_
    val fullname:String = fullname_
    val age:String = age_
    val phone:String = phone_
    val location:String = location_
    val courses = courses_

    constructor():this("","","","","",null)

    companion object {
        fun calcGradeAverage(courses:MutableList<Courses>) : Double {
            return courses.map { it.grade }.average()
        }

        fun stateStudent(prom:Double) : Boolean {
            if(prom > 3.5) {
                return true
            }
            return false
        }

        fun recuperation(prom:Double) : Boolean {
            if (prom > 2.5) {
                return true
            }
            return false
        }
    }
}