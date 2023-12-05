package com.example.expensepartner.api


import com.example.expensepartner.data.model.GistItem
import com.example.expensepartner.data.model.RawText
import com.example.expensepartner.data.model.UserRandom
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface GistApi {

  @GET("bf584ced91b99c6df15ecfc87f0fc882")
  fun fetchPhotos() : Call<GistItem>

  @GET("users")
  fun fetchUser() : Call<UserRandom>

}