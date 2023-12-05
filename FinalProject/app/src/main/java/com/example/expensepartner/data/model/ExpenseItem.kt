package com.example.expensepartner.data.model

import com.google.type.DateTime

data class ExpenseItem (
  val amount: Long,
  val description: String,
  val category: String,
  val channel: String
)