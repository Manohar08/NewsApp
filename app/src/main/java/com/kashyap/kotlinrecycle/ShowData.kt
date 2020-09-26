package com.kashyap.kotlinrecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_show_data.*

class ShowData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        val urldata=intent.getStringExtra("url")
 if(urldata!=null){
     progressbar.visibility= View.GONE
detailedwebview.settings.javaScriptEnabled=true
     detailedwebview.getSettings().userAgentString="Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"

     detailedwebview.webViewClient=object: WebViewClient(){
         override fun onPageFinished(view: WebView?, url: String?) {
             super.onPageFinished(view, url)

             detailedwebview.visibility=View.VISIBLE
         }
     }
     detailedwebview.loadUrl(urldata)
 }


    }
}