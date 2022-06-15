package com.example.findatruck.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.findatruck.databinding.ActivityLogInBinding
import com.example.findatruck.dto.User
import com.example.findatruck.dto.WsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            var usuario = User()
            usuario.usuario = views.user.text.toString().trim()
            usuario.clave = views.user.text.toString().trim()
            WsClient.apiLogeo()?.logearse(usuario)?.enqueue(object :Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful && !response.body().toString().isEmpty()){
                        val intent = Intent ( this@LogIn, ListProduct::class.java)
                        startActivity(intent)
                    }else {
                      Toast.makeText(this@LogIn, "Clave erronea", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@LogIn, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

            })
            //showData()
        }
    }
}
