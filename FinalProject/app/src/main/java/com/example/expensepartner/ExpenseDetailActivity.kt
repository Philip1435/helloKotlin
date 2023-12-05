package com.example.expensepartner

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensepartner.ui.theme.ExpensePartnerTheme
import com.example.expensepartner.utils.EXTRA_AMOUNT
import com.example.expensepartner.utils.EXTRA_CATEGORY
import com.example.expensepartner.utils.EXTRA_CHANNEL
import com.example.expensepartner.utils.EXTRA_DESCRIPTION

class ExpenseDetailActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val amount = intent.extras?.get(EXTRA_AMOUNT)
    val channel = intent.extras?.get(EXTRA_CHANNEL)
    val description = intent.extras?.get(EXTRA_DESCRIPTION)
    val category = intent.extras?.get(EXTRA_CATEGORY)

    setContent {
      ExpensePartnerTheme {
        Column (
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Card(
            colors = CardDefaults.cardColors(
              containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            elevation = CardDefaults.cardElevation(
              defaultElevation = 6.dp
            ),
            modifier = Modifier
              .size(width = 250.dp, height = 250.dp)
              .padding(24.dp)
          ) {
            Text(text = "EXPENSE DETAIL", color = Color.Black, fontSize = 32.sp)
            Column {
              Text(text = "Amount: $amount")
              Text(text = "Category: $category")
              Text(text = "Channel: $channel")
              Text(text = "Description: $description")
            }

          }
        }

      }
    }
  }
}