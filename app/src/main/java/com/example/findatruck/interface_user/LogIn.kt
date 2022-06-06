package com.example.findatruck.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.findatruck.R
import com.example.findatruck.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity() {

    private lateinit var views: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.logInBtn.setOnClickListener {
            showData()
        }
    }
    private fun showData() {
        var intent: Intent = Intent( this, ListProduct::class.java)
        startActivity(intent)
    }
}
