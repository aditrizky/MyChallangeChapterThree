package com.binar.mychallangechapterthree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
   val name: String?=null,
   var age: String?=null,
   val address: String?=null,
   val job: String?=null

): Parcelable
