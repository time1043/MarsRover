package com.time1043.marsrover.service

import com.time1043.marsrover.BuildConfig
import com.time1043.marsrover.service.model.RoverManifestRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverManifestService {

    @GET("mars-photos/api/v1/manifests/{rover_name}?api_key=DEMO_KEY")
    suspend fun getMarsRoverManifest(@Path("rover_name") roverName: String): RoverManifestRemoteModel

    companion object {
        // For real device: use your computer's local network IP (e.g., http://192.168.1.100:3000/)
        // For emulator: use http://10.0.2.2:3000/
        private const val BASE_URL = "http://192.168.43.205:3000/"

        fun create() : MarsRoverManifestService {
            val logger = HttpLoggingInterceptor()
            logger.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverManifestService::class.java)
        }
    }
}