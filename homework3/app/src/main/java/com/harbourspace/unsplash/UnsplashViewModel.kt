package com.harbourspace.unsplash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.unsplash.api.UnsplashApiProvider
import com.harbourspace.unsplash.data.cb.UnsplashResult
import com.harbourspace.unsplash.data.model.Tag
import com.harbourspace.unsplash.data.model.UnsplashItemByID

private const val TAG = "UnsplashViewModel"
class UnsplashViewModel : ViewModel(), UnsplashResult {

  private val _items = MutableLiveData<UnsplashItemByID>()
  val items: LiveData<UnsplashItemByID> = _items

  private val _tags = MutableLiveData<List<Tag>>()
  val tags: LiveData<List<Tag>> = _tags


  private val provider by lazy {
    UnsplashApiProvider()
  }

  fun fetchImages() {
    provider.fetchImages(this)
  }

  override fun onDataFetchedSuccess(images: UnsplashItemByID) {
    Log.d(TAG, "onDataFetchedSuccess | Received images")
    Log.d(TAG, "${tags}")
    _items.value = images
    _tags.value = images.tags
  }

  override fun onDataFetchedFailed() {
    Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
  }
}