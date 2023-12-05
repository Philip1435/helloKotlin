package com.example.expensepartner.api

import androidx.lifecycle.MutableLiveData
import com.example.expensepartner.data.cb.GistResult
import com.example.expensepartner.data.model.GistItem
import com.example.expensepartner.data.model.UserRandom
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


//private const val BASE_URL =  "https://api.github.com/gists/"
private const val BASE_URL =  "https://random-data-api.com/api/v2/"

class GistApiProvider {


  private val retrofit by lazy {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(client)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
      .create<GistApi>()
  }

  fun fetchImages(cb: GistResult) {
    retrofit.fetchUser().enqueue(object : Callback<UserRandom> {
      override fun onResponse(
        call: Call<UserRandom>,
        response: Response<UserRandom>
      ) {
        if (response.isSuccessful && response.body() != null) {
          cb.onDataFetchedSuccess(response.body()!!)
        } else {
          cb.onDataFetchedFailed()
        }

      }

      override fun onFailure(call: Call<UserRandom>, t: Throwable) {
        cb.onDataFetchedFailed()
      }
    })
  }
}