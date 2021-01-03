package com.questdev.rickandmorty.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataClient {

    private const val BASE_URL = "https://api.tvmaze.com/"

    fun getClient(): RemoteService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(RemoteService::class.java)
    }

}