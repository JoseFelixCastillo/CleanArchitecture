package com.josecm.cleanarchitectureapp.datalayer.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO create this class with di
private const val BASE_URL = "https://raw.githubusercontent.com"
class ApiService {
    companion object {

        @Volatile
        private var retrofitInstance: Retrofit? = null

        @Volatile
        private var client: OkHttpClient? = null

        fun getInstance() : Retrofit =
            retrofitInstance ?: synchronized(this) {
                retrofitInstance ?: Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClientInstance())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

        private fun getClientInstance() : OkHttpClient =
            client ?: synchronized(this) {
                client ?: OkHttpClient.Builder()
                    .addInterceptor(getLogger())
                    .build()
            }

        private fun getLogger() : HttpLoggingInterceptor {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            return logger
        }
    }
}