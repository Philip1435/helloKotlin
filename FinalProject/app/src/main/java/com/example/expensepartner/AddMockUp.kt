package com.example.expensepartner

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.expensepartner.data.model.ExpenseItem
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddMockUp(
) {
  Column() {
    Text(text = "Add mockup Data")

    val amount = remember { mutableStateOf("") }
    OutlinedTextField(
      value = amount.value,
      onValueChange = {a -> amount.value = a},
      placeholder = { Text(text = "amount") }
    )


    Button(
      onClick = {
        addDataToFirebase(
          amount = amount.value.toLong(),
          description = "Cash Withdrawal",
          category = "Cash",
          channel = "ATM"
        )
      }
    ) {
      Text(text = "add random data")
    }

  }



}

fun addDataToFirebase(
  amount: Long,
  description: String,
  category: String,
  channel: String
) {
  // on below line creating an instance of firebase firestore.
  val db: FirebaseFirestore = FirebaseFirestore.getInstance()
  //creating a collection reference for our Firebase Firestore database.
  val dbCourses: CollectionReference = db.collection("expense")
  //adding our data to our courses object class.
  val courses = ExpenseItem(amount, description, category, channel)

  //below method is use to add data to Firebase Firestore.
  dbCourses.add(courses)

}