package com.ujjwal.softuserreplica.`object`

import com.ujjwal.softuserreplica.model.Student

object student {
    var listStudent=arrayListOf<Student>();
    fun addStudent() {
        listStudent = arrayListOf();
        listStudent.add(Student(
                name = "Ujjwal Humagain",
                age = "20",
                gender = "Male",
                mobileNumber = "9840452872",
                address = "Kalanki"
        ))
        listStudent.add(Student(
                name = "Aadrika",
                age = "20",
                gender = "Female",
                mobileNumber = "9841212345",
                address = "Baneshwor"
        ))
        listStudent.add(Student(
                name = "Nikesh",
                age = "20",
                gender = "Others",
                mobileNumber = "9847894562",
                address = "Koteshwor"
        ))
    }
}