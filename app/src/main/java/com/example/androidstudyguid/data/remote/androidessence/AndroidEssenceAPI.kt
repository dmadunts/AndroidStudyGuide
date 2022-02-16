@file:Suppress("DEPRECATION")

package com.example.androidstudyguid.data.remote.androidessence

import com.example.androidstudyguid.data.remote.androidessence.models.AndroidEssenceFeed
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

interface AndroidEssenceAPI {
    @GET("feed.xml")
    suspend fun getFeed(): AndroidEssenceFeed

    companion object {
        private const val BASE_URL = "https://androidessence.com"
        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        fun getDefaultApi(): AndroidEssenceAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(AndroidEssenceAPI::class.java)
        }
    }
}
