package com.example.proyectofinalkotlin.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private val BASE_URL = "http://192.168.5.100/appLogginAndPhp/"
        private var retrofit: Retrofit? = null
        private var gson: Gson? = null



        public fun getClient() : Retrofit {
            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}