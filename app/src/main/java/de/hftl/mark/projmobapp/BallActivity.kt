package de.hftl.mark.projmobapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class BallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ball)

        val wv = findViewById<WebView>(R.id.wv_ball)
        wv.settings.javaScriptEnabled = true
        wv.loadUrl("file:///android_asset/Magic8Ball.html")
    }
}
