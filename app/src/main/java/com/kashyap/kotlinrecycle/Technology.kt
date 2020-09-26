package com.kashyap.kotlinrecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Technology : AppCompatActivity() {
  lateinit var   recycle:RecyclerView
    lateinit var adapt:adapterc
    lateinit var model:Model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_technology)
        recycle=findViewById(R.id.technorv1)
        gettechNews()

    }

    private fun gettechNews() {
        val news=newsService.plc.getTechnologydata("in","technology")
        news.enqueue(object: Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(this@Technology,t.message, Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val Model=response.body()
                if(Model!=null)
                {
                    adapt= adapterc(this@Technology, Model.articles)
                    recycle.adapter=adapt
                    recycle.layoutManager= LinearLayoutManager(this@Technology)
                }

            }
        })
    }
}