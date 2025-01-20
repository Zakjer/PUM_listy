package com.example.lista_7

import androidx.lifecycle.ViewModel

class StudentDetailViewModel : ViewModel() {
    private val _studentList = listOf(
        Student("10001", "Jan", "Kowalski", 4.5, 3),
        Student("10002", "Anna", "Nowak", 3.8, 2),
        Student("10003", "Piotr", "Wiśniewski", 5.0, 1),
        Student("10004", "Marek", "Lewark", 4.2, 4),
        Student("10005", "Kasia", "Zawisza", 3.9, 2),
        Student("10006", "Tomasz", "Piotrowski", 4.7, 3),
        Student("10007", "Ewa", "Nowicka", 5.0, 1),
        Student("10008", "Adam", "Wojcieszak", 4.3, 4)
    )

    val studentList: List<Student> get() = _studentList

    fun getStudent(index: Int): Student {
        for (student in _studentList){
            val current_index = student.indexNumber.toInt()
            if (current_index == index) {
                return student
            }
        }
        return Student("", "", "", 0.0, 0)
    }
}
