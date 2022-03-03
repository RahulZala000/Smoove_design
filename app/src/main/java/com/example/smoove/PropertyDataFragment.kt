package com.example.smoove

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_property_data.*


class PropertyDataFragment : Fragment() {

    lateinit var fusedlocation: FusedLocationProviderClient
    var request_code = 101
    var snap: SnapHelper?=null

   val args:PropertyDataFragmentArgs by navArgs<PropertyDataFragmentArgs>()
    lateinit var data:HomeListModelItem
    var map: GoogleMap?=null


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

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        var root=inflater.inflate(R.layout.fragment_property_data, container, false)
        data=args.propertydata!!
    //    binding=FragmentPropertyDataBinding.inflate(layoutInflater)

     /*   val mapFragment = SupportMapFragment.newInstance()
        mapFragment.getMapAsync(this)*/

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
        var frag:View=root.findViewById(R.id.mapfragment)


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

        Toast.makeText(context,data.user.name,Toast.LENGTH_SHORT).show()

        if(data.user.profile_image!=null)
        {
            Glide.with(profile).load(data.user.profile_image)
                .circleCrop()
                .placeholder(R.drawable.pro)
                .error(R.drawable.pro)
                .fallback(R.drawable.pro)
                .into(profile)
        }


     /*   val mapFragment = childFragmentManager.findFragmentById(R.id.mapp) as SupportMapFragment?
        mapFragment?.getMapAsync( object :OnMapReadyCallback{
            override fun onMapReady(p0: GoogleMap) {
                map?.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                map!!.clear()
                val googlePlex = CameraPosition.builder()
                    .target(LatLng(37.4219999, -122.0862462))
                    .zoom(10f)
                    .bearing(0f)
                    .tilt(45f)
                    .build()
               // map!!.uiSettings.isZoomControlsEnabled = true

                val currentLatLng = LatLng(data.latitude, data.longitude)
                map!!.addMarker(MarkerOptions().position(currentLatLng).title("My Location"))
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))

                val nearlocLatLng = LatLng(data.nearest_latitude, data.nearest_longitude)
                map!!.addMarker(MarkerOptions().position(nearlocLatLng).title("Near Location"))
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(nearlocLatLng, 12f))
            }

        } )*/


        return root
    }

}