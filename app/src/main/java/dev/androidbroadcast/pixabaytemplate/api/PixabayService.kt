package dev.androidbroadcast.pixabaytemplate.api

import dev.androidbroadcast.pixabaytemplate.api.data.SearchResponse
import retrofit2.Call
import retrofit2.http.GET

interface PixabayService {

    // https://pixabay.com/api/docs/#api_search_images
    @GET("/")
    fun search(apiKey: String, query: String): Call<SearchResponse>
}