package com.example.lista_7

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentDetailViewModel : ViewModel() {

    // MutableLiveData to hold the selected student
    private val _selectedStudent = MutableLiveData<Student>()

    // Public LiveData to expose the selected student
    val selectedStudent: LiveData<Student> get() = _selectedStudent

    // Function to set the selected student
    fun setStudent(student: Student) {
        _selectedStudent.value = student
    }
}
