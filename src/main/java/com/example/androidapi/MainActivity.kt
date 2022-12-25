package com.example.androidapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androidapi.adapter.UsersAdapter
import com.example.androidapi.models.ListUsers
import com.example.androidapi.models.User

import com.example.androidapi.services.RetrofitClientInstance.retrofitInstance
import com.example.androidapi.services.UsersService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val editText = findViewById<EditText>(R.id.user_id)
        val showButton = findViewById<Button>(R.id.showInput)

        showButton.setOnClickListener {
            getUsers()
        }

    }

    /*private fun getUserById(id: Long) {

        val service = retrofitInstance!!.create(
            UsersService::class.java
        )
        val secondCall: Call<ListUsers?>? = service.getUserById(id)

        secondCall?.enqueue(object : Callback<ListUsers?> {

            override fun onResponse(
                call: Call<ListUsers?>,
                response: Response<ListUsers?>,
            ) {

                listView = findViewById(R.id.user_list_view)

                val res = response.body()!!

                val adapter = UsersAdapter(baseContext, res.id as ArrayList<User>)
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<ListUsers?>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Something went wrong... SHIT Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }*/

    private fun getUsers() {

        val service = retrofitInstance!!.create(
            UsersService::class.java
        )

        val call: Call<List<User?>?>? = service.getUsers()
        call?.enqueue(object : Callback<List<User?>?> {
            override fun onResponse(call: Call<List<User?>?>, response: Response<List<User?>?>) {

                //listView = findViewById(R.id.house_list_view)

                val res = response.body()

                Toast.makeText(this@MainActivity, res.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<User?>?>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Something went wrong...Please try later!",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }


}


