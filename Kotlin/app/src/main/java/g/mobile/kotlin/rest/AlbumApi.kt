package g.mobile.kotlin.rest

import g.mobile.kotlin.model.getAlbum
import g.mobile.kotlin.service.JsonPlaceApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumApi {
    private val jsonPlaceApi : JsonPlaceApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        jsonPlaceApi = retrofit.create(JsonPlaceApi::class.java)
    }

}