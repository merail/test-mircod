package me.rail.mircodtest.service

import me.rail.mircodtest.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {
    companion object {
        fun build(): Service {
            val httpClient = OkHttpClient.Builder()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
            return retrofit.create(Service::class.java)
        }
    }
}