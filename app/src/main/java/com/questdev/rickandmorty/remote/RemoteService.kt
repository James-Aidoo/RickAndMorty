package com.questdev.rickandmorty.remote

import com.questdev.rickandmorty.model.Episode
import retrofit2.Call
import retrofit2.http.GET

interface RemoteService {

    @GET("shows/216?embed=episodes")
    fun getEpisodes(): Call<EpisodeResponse>

}