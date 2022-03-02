package com.example.smoove

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smoove.databinding.FragmentPropertyDataBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_property_data.*

class PropertyDataFragment : Fragment() {

    lateinit var binding: FragmentPropertyDataBinding

   val args:PropertyDataFragmentArgs by navArgs<PropertyDataFragmentArgs>()
    lateinit var data:HomeListModelItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showimg()

    }

    private fun showimg() {
        image_recycle.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter=ImageAdapter(context, data.property_images as ArrayList<PropertyImage>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root=inflater.inflate(R.layout.fragment_property_data, container, false)
        data=args.propertydata
        binding=FragmentPropertyDataBinding.inflate(layoutInflater)

        var username:TextView=root.findViewById(R.id.username)
        var status:TextView=root.findViewById(R.id.user_status)
        var profile:ImageView=root.findViewById(R.id.profile)
        var bedroom:TextView=root.findViewById(R.id.bedroom)
        var bathroom:TextView=root.findViewById(R.id.bathroom)
        var daylisted:TextView=root.findViewById(R.id.daylisted)
        var description:TextView=root.findViewById(R.id.desc)
        var add:TextView=root.findViewById(R.id.location)

        //binding.username.text=data.user.name
        username.text=data.user.name
        status.text=data.status
        bedroom.text=data.bedrooms.toString()
        bathroom.text=data.bathrooms.toString()
        daylisted.text=data.free_within_days
        description.text=data.description
        add.text="${data.address_postcode},${data.address_street_name},${data.address_area},${data.address_city}"




        Toast.makeText(context,data.user.name,Toast.LENGTH_SHORT).show()
       Glide.with(profile).load(data.user.profile_image)
            .circleCrop()
            .placeholder(R.drawable.pro)
            .error(R.drawable.pro)
            .fallback(R.drawable.pro)
            .into(profile)



        return root
    }
}