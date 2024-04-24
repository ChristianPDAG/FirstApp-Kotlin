package com.chris.myfirstapp.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    // Aquí van las variables iniciales, entre ellas accederemos a results para ver sus propiedades
    @SerializedName("response") val response:String,
    @SerializedName("results") val superheros: List<SuperheroItemResponse>
)
data class SuperheroItemResponse(
    // Aquí se especifica a la lista de datos que quieres acceder dentro de la SuperHeroDataResponse
    @SerializedName("id") val superheroId:String,
    @SerializedName("name") val name:String
)