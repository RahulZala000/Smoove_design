package com.example.smoove

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class KeyFesAdapter(private var mList: ArrayList<KeyFeature>): RecyclerView.Adapter<KeyFesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyFesAdapter.ViewHolder
    {
        return KeyFesAdapter.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fes, parent, false))
    }

    override fun onBindViewHolder(holder: KeyFesAdapter.ViewHolder, position: Int) {
        holder.data(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        var keyfes: ImageView =itemView.findViewById(R.id.keyimg)
        var keyname:TextView=itemView.findViewById(R.id.keyname)

        fun data(key: KeyFeature) {

            Glide.with(keyfes).load(key.color_icon_url)
                .centerCrop()
                .placeholder(R.drawable.pro)
                .error(R.drawable.pro)
                .fallback(R.drawable.pro)
                .into(keyfes)

            keyname.text=key.name

        }
    }
}
