package com.example.smoove

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import kotlinx.android.synthetic.main.fragment_property_data.*
import kotlinx.android.synthetic.main.temp.*


class PropertyDataFragment : Fragment() {


   lateinit var map:GoogleMap
    var request_code = 101
    var snap: SnapHelper?=null

   val args:PropertyDataFragmentArgs by navArgs<PropertyDataFragmentArgs>()
    lateinit var data:HomeListModelItem



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showimg()
        showfes()
        showimg1()

    }

    private fun showimg1() {
        image_recycle1.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter=ImageAdapter(context, data.property_images as ArrayList<PropertyImage>)
        }
        snap= LinearSnapHelper()
        (snap as LinearSnapHelper).attachToRecyclerView(image_recycle)
    }

    private fun showfes() {
       keyfes.apply {
           layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
           adapter=KeyFesAdapter(data.key_features as ArrayList<KeyFeature>)
       }
        snap= LinearSnapHelper()
        (snap as LinearSnapHelper).attachToRecyclerView(image_recycle1)
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

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        var root=inflater.inflate(R.layout.fragment_property_data, container, false)
        data=args.propertydata!!
    //    binding=FragmentPropertyDataBinding.inflate(layoutInflater)



        //binding.username.text=data.user.name

        var username:TextView=root.findViewById(R.id.username)
        var status:TextView=root.findViewById(R.id.user_status)
        var profile:ImageView=root.findViewById(R.id.profile)
        var bedroom:TextView=root.findViewById(R.id.bedroom)
        var bathroom:TextView=root.findViewById(R.id.bathroom)
        var daylisted:TextView=root.findViewById(R.id.daylisted)
        var description:TextView=root.findViewById(R.id.desc)
        var add:TextView=root.findViewById(R.id.location)
        var nearloc:TextView=root.findViewById(R.id.nearlocation)
        var nearloctime:TextView=root.findViewById(R.id.nearlocationtime)
        var listtype:TextView=root.findViewById(R.id.list_type)
        var pro_type:TextView=root.findViewById(R.id.pro_type)
        var move_date:TextView=root.findViewById(R.id.move_date)
        var stay:TextView=root.findViewById(R.id.stay)
        var type:TextView=root.findViewById(R.id.type)
        var student:TextView=root.findViewById(R.id.student)
        var deposit:TextView=root.findViewById(R.id.deposit)
        var money:TextView=root.findViewById(R.id.month_money)
        var mapv:MapView=root.findViewById(R.id.map)


        username.text=data.user.name
        status.text=data.status
        bedroom.text=data.bedrooms.toString()
        bathroom.text=data.bathrooms.toString()
        daylisted.text=data.free_within_days
        description.text=data.description
        add.text="${data.address_postcode},${data.address_street_name},${data.address_area},${data.address_city}"
        nearloc.text=data.nearest_location
        nearloctime.text=data.nearest_location_time
        listtype.text=data.listing_type
        pro_type.text=data.property_type
        move_date.text=data.move_in_date
        stay.text=data.length_of_stay
        type.text=data.room_type
        student.text= data.is_suitable_for_student.toString()
        deposit.text=data.deposit_amount.toString()
        money.text="£ ${data.monthly_price}"


        /*map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);
*/
        if(data.user.profile_image_url!=null)
        {
            Glide.with(profile).load(data.user.profile_image)
                .circleCrop()
                .placeholder(R.drawable.pro)
                .error(R.drawable.pro)
                .fallback(R.drawable.pro)
                .into(profile)
        }



        return root
    }


}