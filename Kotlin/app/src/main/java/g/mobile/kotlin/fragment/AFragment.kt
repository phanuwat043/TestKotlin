package g.mobile.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import g.mobile.kotlin.R
import g.mobile.kotlin.adaptor.RecyclerDataList
import g.mobile.kotlin.model.getAlbum
import g.mobile.kotlin.service.JsonPlaceApi
import kotlinx.android.synthetic.main.fragment_a.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AFragment : Fragment() {

    companion object {
        fun newInstance(): AFragment {
            return AFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceApi::class.java)

        service.photoListByAlbumID(1).enqueue(object : Callback<List<getAlbum>> {
            override fun onFailure(call: Call<List<getAlbum>>, t: Throwable) {
                println("Fail!!!")
            }

            override fun onResponse(call: Call<List<getAlbum>>, response: Response<List<getAlbum>>) {
                val ad = RecyclerDataList(response.body()!!)
                recycleView.apply {
                    layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                    isNestedScrollingEnabled = false
                    adapter = ad
                    onFlingListener = null
                }

                ad.notifyDataSetChanged()

            }

        })


    }
}