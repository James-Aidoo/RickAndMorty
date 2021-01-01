package com.questdev.rickandmorty.model

data class Episode(
    val id: Long,
    val url: String,
    val name: String, //this
    val season: Long, //this
    val number: Long, //this
    val type: String,
    val airdate: String,
    val airstamp: String,
    val runtime: Long,
    val image: EpisodeImage, //this
    val summary: String? = null,
)

data class EpisodeImage(
    val medium: String,
    val original: String
)