package de.hftl.mark.projmobapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class BallActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ball)

        var wv = findViewById<WebView>(R.id.wv_ball)
        wv.settings.javaScriptEnabled = true
        wv.loadUrl("file:///android_assets/Magic8Ball.html")
    }
}
