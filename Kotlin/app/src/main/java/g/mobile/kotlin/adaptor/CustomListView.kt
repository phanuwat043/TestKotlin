package g.mobile.kotlin.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import g.mobile.kotlin.R

class CustomListView(context: Context, List: ArrayList<String>) : BaseAdapter() {

    private var list: ArrayList<String> = ArrayList()
    private var context: Context

    init {
        this.list = List
        this.context = context
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var v =  inflater.inflate(R.layout.list_view, null)

        val ms = v.findViewById<TextView>(R.id.textView)
        ms.text = list[p0]

        val del = v.findViewById<ImageView>(R.id.icon_delete)
        del.setOnClickListener {
            list.removeAt(p0)
            this.notifyDataSetChanged()
        }
        return v
    }

}