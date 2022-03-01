package com.example.smoove

import android.content.Context
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*

import java.io.InputStream


class HomeFragment : Fragment(),HomeListAdapter.PostClick,ImageAdapter.ImageClick {

    lateinit var user:HomeListModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showdata()
       // showimg()
    }

   /* private fun showimg() {

        recyclerView.apply {
            images= Gson().fromJson(getdata(requireContext()),PropertyImg::class.java)
            layoutManager= LinearLayoutManager(requireContext())
            adapter=ImageAdapter(this@HomeFragment,images)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root=inflater.inflate(R.layout.fragment_home, container, false)


       user= Gson().fromJson(getdata(requireContext()),HomeListModel::class.java)

        Log.d("userdata",user.properties.size.toString())

        Toast.makeText(context,user.properties.size.toString(), Toast.LENGTH_SHORT).show()
        return root
    }

    private fun showdata() {
        homerecycle.apply {
            layoutManager= LinearLayoutManager(requireContext())
            adapter=HomeListAdapter(this@HomeFragment,user.properties)
        }
    }

    private fun getdata(context: Context): String? {
        var json:String?=null
        var input: InputStream?=null
        try{
            input=context.assets.open("HomeList.json")

            var size=input.available()

            var buffer=ByteArray(size)

            input.read(buffer)

            json=String(buffer)
            return json
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        finally {
            input?.close()
        }
        return null
    }

    override fun onItemFrom(clist: HomeListModelItem) {
        Toast.makeText(context,clist.id.toString(),Toast.LENGTH_SHORT).show()

        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPropertyDataFragment(clist.id))
    }

    override fun OnImgClick(clist: PropertyImage) {
        Toast.makeText(context,clist.id.toString(),Toast.LENGTH_SHORT).show()
    }


}