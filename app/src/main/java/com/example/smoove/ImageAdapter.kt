package com.example.smoove

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.IndicatorView.draw.data.Indicator
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class ImageAdapter(var listner: Context, private var mList:ArrayList<PropertyImage>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder
    {
        return ImageAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.imges, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listner.OnImgClick(mList[position])
        }
        holder.data(mList[position])

    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        var img:ImageView=itemView.findViewById(R.id.imageSlider)

        fun data(propertyImage: PropertyImage) {

            Glide.with(img).load(propertyImage.thumbnail)
                .centerCrop()
                .placeholder(R.drawable.pro)
                .error(R.drawable.pro)
                .fallback(R.drawable.pro)
                .into(img)
        }
    }
    interface ImageClick {
        fun OnImgClick(clist: PropertyImage)

    }
}

private fun Any.OnImgClick(propertyImage: PropertyImage) {

}
