package com.example.marsphotos.network

import retrofit2.http.GET


interface MarsApiService {
    @GET("photos") // get request to /photos endpoint
    suspend fun getPhotos(): List<MarsPhoto>
}

