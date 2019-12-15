package com.aakash.baseimplementation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceManager {

    var BASE_URL:String?=null

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL!!)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}