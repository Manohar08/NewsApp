package com.kashyap.kotlinrecycle

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName ("description" )val description:String, @SerializedName("title")
val title:String, @SerializedName("urlToImage") val image:String,@SerializedName("url")val url:String)
