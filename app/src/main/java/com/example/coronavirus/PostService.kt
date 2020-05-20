package com.example.coronavirus


import retrofit2.http.GET
import retrofit2.Call


interface PostService{

    @GET("/positif/")
    fun getPost(): Call<PostModel>

    @GET("/sembuh/")
    fun getPost2(): Call<PostModel>

    @GET("/meninggal/")
    fun getPost3(): Call<PostModel>

    @GET("/")
    fun getDaftar(): Call<ArrayList<AttributModel>>

    @GET("/indonesia/provinsi/")
    fun getProvinsi(): Call<ArrayList<AtributProvinsi>>


}

