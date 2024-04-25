package com.chris.myfirstapp.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.chris.myfirstapp.R
import com.chris.myfirstapp.databinding.ActivitySuperHeroListBinding
import com.chris.myfirstapp.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()


    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = SuperheroAdapter{navigateToDetail(it)} //superheroId -> navigateToDetail(superheroId)
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheros(query)
            if (myResponse.isSuccessful) {
                Log.i("Hris", "Funciona :)")
                val response: SuperHeroDataResponse? =
                    myResponse.body() // dentro del body está la respuesta
                if (response != null) {
                    Log.i("Hris", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superheros)
                        binding.progressBar.isVisible = false

                    }

                }
            } else {
                Log.i("Hris", "No funciona :(")


            }
        }
    }

    private fun getRetrofit(): Retrofit {
        //Ingresar Url base en la que se trabajará
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

}


