package com.zharick.promedio

public class Registers {

    companion object {
        private val listRegistersStudents = mutableListOf<Students>()

        fun addStudent(data:Students) {
            listRegistersStudents.add(data)
        }

        fun showAllStudents() {
            for (i in listRegistersStudents) {
                println("${i.document} ")
                println("Promedio de notas de ${i.fullname} ${Students.calcGradeAverage(i.courses!!)}")
            }
        }

        fun valueApprovedStudents() : Int {
            var approved = 0
            listRegistersStudents.map {
                val averageStudent = Students.calcGradeAverage(it.courses!!)
                if (Students.stateStudent(averageStudent)) {
                    approved += 1
                }
            }
            return approved
        }

        fun valueRecuperationStudents() : Int {
            var recuperation = 0
            listRegistersStudents.map {
                val averageStudent = Students.calcGradeAverage(it.courses!!)
                if (!Students.stateStudent(averageStudent)) {
                    if (Students.recuperation(averageStudent)) {
                        recuperation += 1
                    }
                }
            }
            return recuperation
        }

        fun lengthRegistersStudents() : Int {
            return listRegistersStudents.size - 1
        }

        fun registerStudent(position:Int) : Students {
            return listRegistersStudents[position]
        }
    }
}