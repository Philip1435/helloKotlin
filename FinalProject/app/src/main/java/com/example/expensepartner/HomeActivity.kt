package com.example.expensepartner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensepartner.ui.theme.ExpensePartnerTheme
import com.example.finalproject.AppPreferences

class HomeActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ExpensePartnerTheme {
        val petname = remember { mutableStateOf("") }
        val enable_button = remember { mutableStateOf(false) }
        Column (
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Text(
            text = "As a security measurement, please answer a following question",
            fontSize = 12.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(18.dp)
          )
          Text(
            text = "What is the name of your first pet",
            fontSize = 20.sp
          )
          OutlinedTextField(
            value = petname.value,
            onValueChange = { input -> petname.value = input },
            label = { Text(text = "name") },
          )

          if (petname.value != "") {
            enable_button.value = true
          }

          Row (
            modifier = Modifier
              .fillMaxWidth()
              .padding(18.dp),
            horizontalArrangement = Arrangement.Center
          ){
            Button(
              modifier = Modifier,
              onClick = {
                AppPreferences(this@HomeActivity).setOption(petname.value)
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intent)
              },
              enabled = enable_button.value
            ) {
              Text(text = "next", color = Color.White)
            }
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun CustomCheckboxExample() {
  val checked = remember { mutableStateOf(false) }

  Column {
    Checkbox(
      checked = checked.value,
      onCheckedChange = { isChecked -> checked.value = isChecked },
      colors = CheckboxDefaults.colors(checkedColor = Color.Gray, uncheckedColor = Color.Blue)
    )
    Text("Custom checkbox is ${if (checked.value) "checked" else "unchecked"}")
  }
}