package com.example.expensepartner.data.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.himanshoe.charty.common.ChartData

data class BarChartData (
  val yValue: Float,
  val xValue: Any,
  val color: Color? = null
)