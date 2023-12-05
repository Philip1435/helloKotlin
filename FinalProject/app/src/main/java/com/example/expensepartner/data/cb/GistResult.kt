package com.example.expensepartner.data.cb

import com.example.expensepartner.data.model.GistItem
import com.example.expensepartner.data.model.RawText
import com.example.expensepartner.data.model.UserRandom

interface GistResult {

  fun onDataFetchedSuccess(images: UserRandom)
  fun onDataFetchedFailed()
}