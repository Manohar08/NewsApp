package com.kashyap.kotlinrecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapterc(val context: Context, val al1: List<Data>) :
    RecyclerView.Adapter<adapterc.viewh>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewh {
        var view = LayoutInflater.from(context).inflate(R.layout.recycl, parent, false)


        return viewh(view);
    }

    override fun getItemCount(): Int {
        return al1.size
    }

    override fun onBindViewHolder(holder: viewh, position: Int) {
        var data = al1[position]


        holder.textView2.text = data.description
        holder.textView1.text=data.title

        Glide.with(context).load(data.image).into(holder.imageView)
        holder.itemView.setOnClickListener{
            Toast.makeText(context,data.title,Toast.LENGTH_SHORT).show()
            var Tiles=data.title
            var Desc=data.description


           val intent=Intent(context,ShowData::class.java).apply {
               putExtra("title",Tiles)
               putExtra("desc",Desc)
               putExtra("url",data.url)
           }
          context.startActivity(intent)
        }


    }

    class viewh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.iv1);

        var textView2 = itemView.findViewById<TextView>(R.id.tvdescription)
        var textView1 = itemView.findViewById<TextView>(R.id.tvtitle)


    }

}