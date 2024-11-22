package com.example.proyectofinalkotlin.api

import com.example.proyectofinalkotlin.model.login.DataLogin
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.example.proyectofinalkotlin.model.register.DataRegister
import retrofit2.http.Field

interface ApiInterface {



    @FormUrlEncoded
    @POST("login.php")
    fun loginResponse (
            @Field("usu_nombre")  usuNombre :String,
            @Field("usu_password")  usuPsswd :String

    ): Call<DataLogin>

    @FormUrlEncoded
    @POST("register.php")
    fun registerResponse (
            @Field("usu_nombre")  username :String,
            @Field("usu_password")  usuPsswd :String,
            @Field("nombre")  nombre :String

    ): Call<DataRegister>




}