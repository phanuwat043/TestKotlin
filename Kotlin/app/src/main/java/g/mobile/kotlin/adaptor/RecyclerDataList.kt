package g.mobile.kotlin.adaptor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import g.mobile.kotlin.R
import g.mobile.kotlin.model.getAlbum
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerDataList(private var item : List<getAlbum>):RecyclerView.Adapter<RecyclerDataList.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_list,p0,false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(item[p1])
    }

    class ViewHolder(itemList : View):RecyclerView.ViewHolder(itemList){
        fun bind(getAlbum: getAlbum){
            itemView.apply {
                textMsg.text = getAlbum.thumbnailUrl
                textName.text = getAlbum.title
            }
            Picasso.get().load(getAlbum.url).into(itemView.imgView)

        }
    }
}