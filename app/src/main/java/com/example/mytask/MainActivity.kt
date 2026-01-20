
package com.example.mytask

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytask.Adapter.userDetailsAdapter
import com.example.mytask.Model.User
import com.example.mytask.databinding.ActivityMainBinding
import com.example.mytask.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding  : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiService: ApiInterface = RetrofitInstance.apiInterface

        val call: Call<List<User?>?>? = apiService.getUserData()

        call?.enqueue(object : Callback<List<User?>?> {
            override fun onResponse(call: Call<List<User?>?>, response: Response<List<User?>?>) {

                val userList = response.body()

                binding.userDataRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
                binding.userDataRecyclerView.adapter = userList?.let { userDetailsAdapter(it) }

            }

            override fun onFailure(call: Call<List<User?>?>, t: Throwable) {

            }
        })
    }
}