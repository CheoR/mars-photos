package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) // to convert to string
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos") // get request to /photos endpoint
    fun getPhotos(): String

}

// to initialize Retrofit service
// public singleton object that rest of app can access
object MarsApi {
    // lazy initialization to make sure it is initialized at its first usage
    // Each time app calls MarsApi.retrofitService, caller accesses same singleton Retrofit object
    // that implements MarsApiService, which is created on the first access.
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

