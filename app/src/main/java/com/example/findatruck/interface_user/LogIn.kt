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
            val userText = views.user.text.toString()
            val passwordText = views.password.text.toString()

            userText?.let {
                passwordText?.let { itp ->
                    if (it.equals("jav_ayora") && itp.equals("123456")) {
                        showData(userText)
                    }
                }
            }
        }
    }

    private fun showData(userText:String) {
        var intent: Intent = Intent( this, ListProduct::class.java)
        startActivity(intent)
    }
}
