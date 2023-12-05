package com.example.expensepartner.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.expensepartner.ExpenseViewModel
import com.example.expensepartner.data.model.ExpenseItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpenseHistoryScreen (
  expenseViewModel: ExpenseViewModel,
  onAction: (ExpenseItem) -> Unit
) {
  val expenseItem = expenseViewModel.items.observeAsState(emptyList())

  LazyColumn {

    item {
      Column {
        Text(
          modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp),
          text = "Expense History", fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
      }

    }


    items(expenseItem.value) { expense ->
//      ExpenseCard(
//        amount = expense.amount,
//        channel = expense.channel,
//        description = expense.description,
//        category = expense.category,
//        onAction = { item -> onAction(item) }
//      )
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .height(150.dp)
          .padding(horizontal = 24.dp, vertical = 12.dp)
          .clip(RoundedCornerShape(10.dp))
          .clickable { onAction(expense) },
        border = BorderStroke(1.dp, Color.Black)
      ) {
        val colorStops = arrayOf(
          0.2f to Color.LightGray,
          1f to Color.White
        )
        Row (
          modifier = Modifier
            .background(Brush.horizontalGradient(colorStops=colorStops))
        ) {
          Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
              .fillMaxHeight()
              .padding(vertical = 16.dp, horizontal = 8.dp)

          ) {
            Text(text = "category", fontWeight = FontWeight.Bold)
            Text(text = "channel", fontWeight = FontWeight.Bold)
            Text(text = "description", fontWeight = FontWeight.Bold)
          }
          Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
              .fillMaxHeight()
              .padding(vertical = 16.dp, horizontal = 8.dp)
          ) {
            Text(text = "${expense.category}")
            Text(text = "${expense.channel}")
            Text(text = "${expense.description}")
          }
          Column (
            modifier = Modifier
              .fillMaxHeight()
              .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "${expense.amount} THB", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
          }
        }
      }
    }


  }
}

@Composable
fun ExpenseCard (
  amount: Long,
  channel: String,
  description: String,
  category: String,
  onAction: (ExpenseItem) -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(150.dp)
      .padding(horizontal = 24.dp, vertical = 12.dp)
      .clip(RoundedCornerShape(10.dp))
//      .clickable { onAction(it) }
  ) {
    val colorStops = arrayOf(
      0.2f to Color.LightGray,
      1f to Color.White
    )
    Row (
      modifier = Modifier
      .background(Brush.horizontalGradient(colorStops=colorStops))
    ) {
      Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .fillMaxHeight()
          .padding(vertical = 16.dp, horizontal = 8.dp)

      ) {
        Text(text = "category", fontWeight = FontWeight.Bold)
        Text(text = "channel", fontWeight = FontWeight.Bold)
        Text(text = "description", fontWeight = FontWeight.Bold)
      }
      Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .fillMaxHeight()
          .padding(vertical = 16.dp, horizontal = 8.dp)
      ) {
        Text(text = "$category")
        Text(text = "$channel")
        Text(text = "$description")
      }
      Column (
        modifier = Modifier
          .fillMaxHeight()
          .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

      ) {
        Text(text = "$amount THB", fontSize = 20.sp)
      }
    }
  }
}