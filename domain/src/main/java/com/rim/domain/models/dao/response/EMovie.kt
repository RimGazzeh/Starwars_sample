package com.rim.domain.models.dao.response

import com.rim.domain.models.entities.Movie
import com.squareup.moshi.Json

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
data class EMovie(
    val characters: List<String>,
    val director: String,
    val episode_id: Int,
    val opening_crawl: String,
    val planets: List<String>,
    val producer: String,
    val release_date: String,
    val species: List<String>,
    @field:Json(name = "starships")
    val starShips: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
)

fun EMovie.toEntity() = Movie(title, producer, director, release_date, opening_crawl)
fun List<EMovie>.toEntity() = map { it.toEntity() }