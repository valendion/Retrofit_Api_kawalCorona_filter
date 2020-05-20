package com.example.coronavirus

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRespository{

    fun create(): PostService{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.kawalcorona.com")
            .build()
        return retrofit.create(PostService::class.java)

    }


}