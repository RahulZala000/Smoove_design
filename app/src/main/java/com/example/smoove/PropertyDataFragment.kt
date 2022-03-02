package com.example.smoove

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.divider.MaterialDividerItemDecoration

class PropertyDataFragment : Fragment() {

    val args:PropertyDataFragmentArgs by navArgs<PropertyDataFragmentArgs>()
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root=inflater.inflate(R.layout.fragment_property_data, container, false)

        recyclerView=root.findViewById(R.id.recycle)

        var data:CustomData=args.properties

        //var profil: ImageView =root.findViewById(R.id.profile)
      //  var username: TextView =root.findViewById(R.id.user_name)
        var userstatus: TextView =root.findViewById(R.id.user_status)

      //  username.text=data.user.name
        userstatus.text=data.property_type

     /*   Glide.with(profil).load(data.user.profile_image)
            .circleCrop()
            .placeholder(R.drawable.pro)
            .error(R.drawable.pro)
            .fallback(R.drawable.pro)
            .into(profil)*/


        return root
    }
}