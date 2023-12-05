package com.example.expensepartner.data.cb

import com.example.expensepartner.data.model.ExpenseItem

interface ExpenseResult {
  fun onDataFetchedSuccess(images: List<ExpenseItem>)

  fun onDataFetchedFailed()
}
