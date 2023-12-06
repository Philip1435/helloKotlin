package com.harbourspace.unsplash.api

import com.harbourspace.unsplash.data.model.UnsplashItemByID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "ngak5Lv2ZsDvYfnAJjyMP0mnV23pWs5hcvOBXceV3Wc"
private const val PHOTO_ID = "g5Uh7nP60FA"

interface UnsplashApi {

  @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
  @GET("photos/$PHOTO_ID")
  fun fetchPhotoByID() : Call<UnsplashItemByID>
}