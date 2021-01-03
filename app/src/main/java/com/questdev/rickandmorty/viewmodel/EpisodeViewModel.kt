package com.questdev.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import com.questdev.rickandmorty.remote.EpisodeResponse
import com.questdev.rickandmorty.remote.RemoteDataClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    fun getEpisodes(callback: ResponseCallback) {
        val call = RemoteDataClient.getClient().getEpisodes()

        call.enqueue(object : Callback<EpisodeResponse> {
            override fun onResponse(call: Call<EpisodeResponse>, response: Response<EpisodeResponse>) {
                if (response.isSuccessful)
                    callback.execute(response.body())
            }

            override fun onFailure(call: Call<EpisodeResponse>, t: Throwable) {
                t.printStackTrace()
                callback.execute(t.localizedMessage)
            }
        })

    }

}

interface ResponseCallback {

    fun execute(data: Any?)

}