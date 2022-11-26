package com.yonasoft.minimal.network

import com.yonasoft.minimal.model.anime_detail_model.AnimeDetail
import com.yonasoft.minimal.model.anime_model.Anime
import retrofit2.Response
import retrofit2.http.*


interface MALApi {

    @GET("anime/ranking")
    suspend fun getAnimeRanking(
        @Header("X-MAL-CLIENT-ID") clientId: String,
        @Query("ranking_type") rankingType:String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("fields") fields: String

    ): Response<Anime>

    @GET("anime/season/{year}/{season}")
    suspend fun getAnimeSeasonal(
        @Header("X-MAL-CLIENT-ID") clientId: String,
        @Path("year") year: Int,
        @Path("season") season: String,
        @Query("sort") sort:String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("fields") fields: String
        ): Response<Anime>

    @GET("anime/suggestions")
    suspend fun getAnimeSuggested(
        @Header("X-MAL-CLIENT-ID") clientId: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("fields") fields: String
    ): Response<Anime>

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(
        @Header("X-MAL-CLIENT-ID") clientId: String,
        @Path("anime_id") animeId:Int,
        @Query("fields") fields: String
    ): Response<AnimeDetail>
}