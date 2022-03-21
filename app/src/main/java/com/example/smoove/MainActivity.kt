package com.example.smoove

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.animation.core.animateValueAsState
import androidx.navigation.NavController
import com.example.smoove.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    lateinit var navcontroller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    override fun navigateUpTo(upIntent: Intent?): Boolean {
        return navcontroller.navigateUp()
    }

}