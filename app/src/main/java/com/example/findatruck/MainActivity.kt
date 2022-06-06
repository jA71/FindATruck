package com.example.findatruck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.findatruck.databinding.ActivityMainBinding
import com.example.findatruck.interface_user.LogIn

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.continueButton.setOnClickListener {
            goToPrincipal()
        }
    }

    private fun goToPrincipal() {
        var intent: Intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }
}