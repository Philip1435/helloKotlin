package com.example.expensepartner

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.expensepartner.api.GistApiProvider
import com.example.expensepartner.data.cb.GistResult
import com.example.expensepartner.data.model.ExpenseItem
import com.example.expensepartner.data.model.GistItem
import com.example.expensepartner.data.model.RawText
import com.example.expensepartner.data.model.UserRandom
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


private const val TAG = "UnsplashViewModel"

class ExpenseViewModel : ViewModel(), GistResult {
  private val _items = MutableLiveData<List<ExpenseItem>>()
  val items: LiveData<List<ExpenseItem>> = _items

  private val _rawtext = MutableLiveData<UserRandom>()
  val rawtext: LiveData<UserRandom> = _rawtext

  val db = Firebase.firestore
  val collectionRef = db.collection("expense")

  private val provider by lazy {
    GistApiProvider()
  }

  fun fetchtext() {
    return provider.fetchImages(this)
  }

  override fun onDataFetchedSuccess(rt: UserRandom) {
    Log.d(TAG, "onDataFetchedSuccess | Received text")
    _rawtext.value = rt
  }

  override fun onDataFetchedFailed() {
    Log.e(TAG, "onDataFetchedFailed | Unable to retrieve images")
  }

  fun getallexpense() {
    collectionRef.get()
      .addOnSuccessListener { result ->
        val temp = mutableListOf<ExpenseItem>()
        for (document in result) {
          Log.d(TAG, "${document.id} => ${document.data}")
          val amount = document.get("amount") as Long
          val description = document.get("description") as String
          val category = document.get("category") as String
          val channel = document.get("channel") as String

          temp.add(
            ExpenseItem(
            amount = amount,
            description = description,
            category = category,
            channel = channel
          )
          )
        }


        _items.value = temp
      }
      .addOnFailureListener { exception ->
        Log.d(TAG, "Error getting documents: ", exception)
      }

  }

  init {
    getallexpense()
  }

}