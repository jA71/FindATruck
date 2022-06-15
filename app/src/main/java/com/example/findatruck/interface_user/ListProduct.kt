package com.example.findatruck.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findatruck.Adaptador
import com.example.findatruck.R
import com.example.findatruck.databinding.ActivityListProductBinding
import com.example.findatruck.dto.Product
import com.example.findatruck.dto.WsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListProduct : AppCompatActivity() {
    private lateinit var views: ActivityListProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(views.root)
        initialConfiguration()
        addListProducts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share_list -> {
                Toast.makeText(this, "Quiero Compartir", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.settings_list -> {
                val intent = Intent(this, Preferences::class.java)
                startActivity(intent)
                true
            }
            R.id.example_list -> {
                Toast.makeText(this,"Hola Ejemplo", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                true
        }
            else -> super.onOptionsItemSelected(item)
        }

    }


    private fun initialConfiguration() {
        views.listItems.layoutManager = LinearLayoutManager(this)
    }


    private fun addListProducts() {
        WsClient.apiLista()?.buscarListaProductos()?.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val list = response.body()!!
                    views.listItems.adapter = Adaptador(list)
                } else {
                    Toast.makeText(
                        this@ListProduct,
                        android.R.string.httpErrorBadUrl,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(
                    this@ListProduct,
                    android.R.string.httpErrorBadUrl,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}