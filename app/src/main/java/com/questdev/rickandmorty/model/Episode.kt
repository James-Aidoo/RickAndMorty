package com.questdev.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Episode(
    val id: Long,
    val url: String,
    val name: String,
    val season: Long,
    val number: Long,
    val type: String,
    @SerializedName("airdate")
    val airDate: String,
    @SerializedName("airstamp")
    val airStamp: String,
    val runtime: Long,
    val image: EpisodeImage,
    val summary: String? = null,
)

data class EpisodeImage(
    val medium: String,
    val original: String
)