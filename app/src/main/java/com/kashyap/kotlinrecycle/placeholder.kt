package com.kashyap.kotlinrecycle

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val baseurl="http://newsapi.org/"
const val Apikey="fce2cc6e32ac4d3796a52ec79b174e73"
interface placeholders {

    @GET("/v2/top-headlines?apiKey=$Apikey")
    fun getdata(@Query("country") Country: String): Call<Model>
    @GET("/v2/top-headlines?apiKey=$Apikey")
    fun getTechnologydata(@Query("country")country:String,@Query("category")technology:String):Call<Model>
}
    object newsService {
        val plc: placeholders

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
                .build()
            plc = retrofit.create(placeholders::class.java)
        }


    }
