package com.example.smoove

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.divider.MaterialDividerItemDecoration

class HomeListAdapter(var listner: HomeFragment, private var mList: List<HomeListModelItem>): RecyclerView.Adapter<HomeListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listner.onItemFrom(mList[holder.layoutPosition])
        }
        holder.data(mList[position])

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        var streetname: TextView = itemView.findViewById(R.id.streetname)
        var address: TextView = itemView.findViewById(R.id.address)
        var money: TextView = itemView.findViewById(R.id.money)
        var status: TextView = itemView.findViewById(R.id.status)
        var bathroom: TextView = itemView.findViewById(R.id.bathroom)
        var bedroom: TextView = itemView.findViewById(R.id.bedroom)
        var profile:ImageView=itemView.findViewById(R.id.profile)
        var nearloc: TextView = itemView.findViewById(R.id.nearlocation)
        var nearloctime: TextView = itemView.findViewById(R.id.nearlocationtime)
        var recyclerView:RecyclerView=itemView.findViewById(R.id.recycle)

        var snap: SnapHelper?=null

        fun data(get: HomeListModelItem) {
            streetname.text=get.address_area
            address.text="${get.address_postcode},${get.address_street_name},${get.address_area}"
            money.text="£ ${get.monthly_price}"
            status.text=get.status
            bedroom.text=get.bedrooms.toString()
            bathroom.text=get.bathrooms.toString()
            nearloc.text= get.nearest_location
            nearloctime.text= get.nearest_location_time

            recyclerView.apply {
                layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                adapter=ImageAdapter(context, get.property_images as ArrayList<PropertyImage>)

                var div=
                    DividerItemDecoration(context, MaterialDividerItemDecoration.VERTICAL)

                addItemDecoration(div)
            }
            snap= LinearSnapHelper()
            (snap as LinearSnapHelper).attachToRecyclerView(recyclerView)

            Glide.with(profile).load(get.user.profile_image)
                .circleCrop()
                .placeholder(R.drawable.pro)
                .error(R.drawable.pro)
                .fallback(R.drawable.pro)
                .into(profile)
        }
    }
    interface PostClick {
        fun onItemFrom(clist: HomeListModelItem)
    }
}