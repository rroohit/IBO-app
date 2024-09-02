package roh.com.iboapp.di.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import roh.com.iboapp.data.network.ApiService

object NetworkModule { // not added di

    const val BASE_URL = "https://www.whats-on-netflix.com/wp-content/plugins/whats-on-netflix/"
    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

}