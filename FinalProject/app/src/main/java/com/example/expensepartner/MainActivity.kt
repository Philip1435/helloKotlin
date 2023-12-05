package com.example.expensepartner

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beust.klaxon.Klaxon
import com.example.expensepartner.data.model.ExpenseItem
import com.example.expensepartner.data.model.GistItem
import com.example.expensepartner.ui.AnalyticScreen
import com.example.expensepartner.ui.ExpenseHistoryScreen
import com.example.expensepartner.ui.theme.ExpensePartnerTheme
import com.example.expensepartner.utils.EXTRA_AMOUNT
import com.example.expensepartner.utils.EXTRA_CATEGORY
import com.example.expensepartner.utils.EXTRA_CHANNEL
import com.example.expensepartner.utils.EXTRA_DESCRIPTION
import com.example.finalproject.AppPreferences
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.harbourspace.unsplash.ui.BottomNavigationScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

  private val expenseViewModel: ExpenseViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    expenseViewModel.fetchtext()

    setContent {
      ExpensePartnerTheme {
        val userInfo = expenseViewModel.rawtext.observeAsState()
        val pet_name = AppPreferences(this@MainActivity).getOptions()
        val name_surname = "${userInfo.value?.first_name} ${userInfo.value?.last_name}"
        val profile_url = "${userInfo.value?.avatar}"

        val navController = rememberNavController()

        Scaffold(
          bottomBar = {
            val items = listOf(
              BottomNavigationScreen.Analytic,
              BottomNavigationScreen.History
            )

            val selected = remember { mutableIntStateOf(0) }

            NavigationBar {
              items.forEachIndexed { index, bottomNavigationScreen ->
                NavigationBarItem(
                  selected = selected.intValue == index,
                  onClick = {
                    selected.intValue = index
                    navController.navigate(bottomNavigationScreen.route)
                  },
                  icon = {
                    Icon(
                      painter = painterResource(id = bottomNavigationScreen.icon),
                      contentDescription = stringResource(id = bottomNavigationScreen.title)
                    )
                  },
                  label = {
                    Text(text = stringResource(bottomNavigationScreen.title))
                  }
                )
              }
            }
          },

          content = {
            Column(modifier = Modifier.padding(it)) {
              NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.Analytic.route,
                builder = {
                  composable(BottomNavigationScreen.Analytic.route) {
                    if (pet_name != null) {
                      AnalyticScreen(pet_name, name_surname, profile_url)
                    }
                  }

                  composable(BottomNavigationScreen.History.route) {
                    ExpenseHistoryScreen(
                      expenseViewModel = expenseViewModel,
                      onAction = { expense -> openDetails(expense)}
                    )
                  }
                }
              )
            }
          }
        )
      }
    }

  }
  private fun openDetails(expense: ExpenseItem) {
    val intent = Intent(this@MainActivity, ExpenseDetailActivity::class.java)
    intent
      .putExtra(EXTRA_AMOUNT, expense.amount)
      .putExtra(EXTRA_CATEGORY, expense.category)
      .putExtra(EXTRA_CHANNEL, expense.channel)
      .putExtra(EXTRA_DESCRIPTION, expense.description)
    startActivity(intent)
  }
}
