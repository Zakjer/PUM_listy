package com.example.lista_7

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val indexNumber: String,
    val firstName: String,
    val lastName: String,
    val averageGrade: Double,
    val year: Int
) : Parcelable

