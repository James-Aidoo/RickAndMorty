package com.questdev.rickandmorty.remote

import com.google.gson.annotations.SerializedName
import com.questdev.rickandmorty.model.Episode

data class EpisodeResponse(
    val id: Int,

    @SerializedName("_embedded")
    val embedded: Embedded
)

data class Embedded(
    val episodes: List<Episode>
)

