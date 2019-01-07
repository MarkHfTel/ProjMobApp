package de.hftl.mark.projmobapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

//Ich habe das Problem, dass ich hier im Adapter keinen Context habe und deswegen nicht die Details anzeigen kann.
//Dies führt durch die RecyclerView zu Problemen, die sich dann bei der Sensoren- und Kontakten Detailansicht zeigen.
class SenAdapter(private val arrList: ArrayList<String>, private val mContext: Context) :
    RecyclerView.Adapter<SenAdapter.MyViewHolder>() {
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById(R.id.text_item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = arrList[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("position", position)
            Log.d("YYYY", "Start DetailActivity")
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount() = arrList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SenAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(layout)
    }
}