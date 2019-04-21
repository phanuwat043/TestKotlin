package g.mobile.kotlin.service

import g.mobile.kotlin.model.getAlbum
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonPlaceApi {

    @GET("/photos")
    fun photoListByAlbumID(@Query("albumId") albumId : Int):Call<List<getAlbum>>

}