package com.example.smoove

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smoove.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.InputStream

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