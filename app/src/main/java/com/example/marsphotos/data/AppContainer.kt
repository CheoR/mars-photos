package com.example.marsphotos.data

import retrofit2.Retrofit
import com.example.marsphotos.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

class DefaultAppContainer : AppContainer {

    /**
     * removed const keyword. Removing const is necessary because BASE_URL is no longer a top level
     * variable and is now DefaultAppContainer class. Refactor to camelcase baseUrl.
     */
    private val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com"

    /**
     * Use Retrofit builder to build retrofit object using kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }

}
