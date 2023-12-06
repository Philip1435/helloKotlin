package com.harbourspace.unsplash.data.cb

import com.harbourspace.unsplash.data.model.UnsplashItemByID

interface UnsplashResult {

  fun onDataFetchedSuccess(images: UnsplashItemByID)

  fun onDataFetchedFailed()
}