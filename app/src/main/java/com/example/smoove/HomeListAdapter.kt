package com.example.smoove

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeListAdapter(var listner: HomeFragment, private var mList:ArrayList<HomeListModelItem>): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var item=mList[position]
        holder.itemView.setOnClickListener{
            listner.onItemFrom(mList[position])
        }
        //holder.data(mList[position])
        holder.main_img.setImageResource()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

       // val id: TextView = itemView.findViewById(R.id.id)
      //  val user_id: TextView = itemView.findViewById(R.id.user_id)
       // val address_street_name: TextView = itemView.findViewById(R.id.address_street_name)
       val main_img: ImageView = itemView.findViewById(R.id.main_img)

      /*  fun data(get: HomeListModelItem) {
         *//*   id.text=get.id.toString()
            user_id.text=get.user_id.toString()
            address_street_name.text=get.address_street_name*//*
            main_img.setImageResource()

        }*/
    }
    interface PostClick {
        fun onItemFrom(clist: HomeListModelItem)

    }
}