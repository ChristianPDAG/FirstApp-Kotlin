package com.chris.myfirstapp.superheroapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chris.myfirstapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)
        val id: String =
            intent.getStringExtra(EXTRA_ID).orEmpty()  //si es nulo devuelve un vacio (.orEmpty)
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch { //corrutina
            val superHeroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)
            if (superHeroDetail.body()!= null){
                runOnUiThread { createdUI(superHeroDetail.body()!!) }

            }

        }
    }

    private fun createdUI(body: SuperHeroDetailResponse) {

    }

    private fun getRetrofit(): Retrofit {
        //Ingresar Url base en la que se trabajará
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
