package com.harbourspace.unsplash.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.expensepartner.R

sealed class BottomNavigationScreen(
    val route: String,
    @StringRes val title: Int,
    val icon: Int
) {

    data object Analytic: BottomNavigationScreen(
        "Analytic",
        R.string.main_tab_analytic,
        R.drawable.monitoring
    )

    data object History: BottomNavigationScreen(
        "History",
        R.string.main_tab_history,
        R.drawable.history
    )

}