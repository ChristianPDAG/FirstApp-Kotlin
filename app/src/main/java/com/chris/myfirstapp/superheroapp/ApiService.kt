package com.chris.myfirstapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/acb78fb5e38f58c5b74402e8dff14e1f/search/{name}/")
    suspend fun getSuperheros(@Path("name") superheroName:String):Response<SuperHeroDataResponse>

    @GET("/api/acb78fb5e38f58c5b74402e8dff14e1f/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>

}