package com.rim.domain.models.entities

import java.io.Serializable

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
data class Movie(
    val title: String,
    val producer: String,
    val director: String,
    val releaseDate: String,
    val openingCrawl: String,
    val created: String,
    val edited: String
) : Serializable