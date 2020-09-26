package com.kashyap.kotlinrecycle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

lateinit var recycle :RecyclerView

lateinit var adapt:adapterc
    lateinit var model:Model
    lateinit var drawer:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      recycle=findViewById<RecyclerView>(R.id.recycle1)
        var toolbar=findViewById<Toolbar>(R.id.toolbar1)
        setSupportActionBar(toolbar)
        drawer=findViewById<DrawerLayout>(R.id.drawer_layout)
        var toggle= ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open
            ,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationbar=findViewById<NavigationView>(R.id.navigation)
        navigationbar.setNavigationItemSelectedListener(this)


      getNews()


    }

    private fun getNews() {
   val news=newsService.plc.getdata("in")
        news.enqueue(object:Callback<Model>{
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                       val Model=response.body()
                if(Model!=null)
                {
                adapt= adapterc(this@MainActivity, Model.articles)
                    recycle.adapter=adapt
                    recycle.layoutManager=LinearLayoutManager(this@MainActivity)
                }

            }
        })


    }

    /*fun normalrecycleview(){

        al1.add(Model("Manohar ",R.drawable.ic_launcher_foreground))
        al1.add(Model("kashyap",R.drawable.ic_launcher_background))
        adapt= adapterc(this,al1 )
        recycle.adapter=adapt
        recycle.layoutManager= LinearLayoutManager(this@MainActivity)
    }*/
    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
      when(item.itemId){
          R.id.it1->{
              var intent=Intent(this,Technology::class.java)
              startActivity(intent)
          }
          R.id.it2->{

          }
          R.id.menuit1->{

          }
      }
        drawer.closeDrawer(GravityCompat.START)
        return  true
    }


}