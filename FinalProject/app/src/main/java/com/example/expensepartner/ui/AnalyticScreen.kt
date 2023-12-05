package com.example.expensepartner.ui

import android.content.Context
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.expensepartner.ExpenseViewModel
import com.example.expensepartner.MainActivity
import com.example.expensepartner.R
import com.example.expensepartner.data.model.BarChartData
import com.example.expensepartner.data.model.ExpenseItem
import com.example.finalproject.AppPreferences
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firestore.v1.StructuredAggregationQuery.Aggregation.Count
import com.himanshoe.charty.common.ChartData
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.AxisConfig
import com.himanshoe.charty.common.config.ChartDefaults

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnalyticScreen(
  pet_name: String,
  name_surname: String,
  profile_url: String
) {
  Column (
    modifier = Modifier
      .padding(24.dp)
  ){
    val painter = rememberAsyncImagePainter(
      model = ImageRequest
        .Builder(LocalContext.current)
        .data(profile_url)
        .build())

    Text(text = "Expense Analytics", fontSize = 26.sp)
    Divider(thickness = 1.dp, color = Color.LightGray)
    Spacer(modifier = Modifier.height(8.dp))
    Row (
      verticalAlignment = Alignment.CenterVertically
    ){
      Text(text = "$name_surname", fontSize = 20.sp)
      Spacer(modifier = Modifier.width(4.dp))
      Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(24.dp)
          .clip(CircleShape)
          .border(BorderStroke(1.dp, Color.Black), CircleShape))
    }

    Text(text = "whose first pet was $pet_name (sorry privacy isn't real in 2023)", fontSize = 12.sp)

  }



  
  Column (
    modifier = Modifier
      .fillMaxHeight()
      .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ){
    Image(painter = painterResource(id = R.drawable.bg), contentDescription = null)
  }


  val chartData: List<ChartData> = listOf(


  )

  val data = ChartDataCollection(chartData)

}

@Composable
fun BarChart(
  dataCollection: ChartDataCollection,
  modifier: Modifier = Modifier,
  barSpacing: Dp = 8.dp,
  padding: Dp = 16.dp,
  barColor: Color = Color.Blue,
  axisConfig: AxisConfig = ChartDefaults.axisConfigDefaults(),
){
  // Implementation details...
}