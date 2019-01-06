package de.hftl.mark.projmobapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class MagicTrick : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic)
        findViewById<ImageView>(R.id.imageView_magicBase).setOnClickListener(this)
        findViewById<ImageView>(R.id.imageView_magicHide).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val mHandler = Handler(Looper.getMainLooper())

        if (findViewById<ImageView>(R.id.imageView_magicHide).visibility == View.VISIBLE) {
            findViewById<ImageView>(R.id.imageView_magicHide).visibility = View.INVISIBLE
            findViewById<ImageView>(R.id.imageView_magicBase).visibility = View.VISIBLE
            Thread {
                Thread.sleep(10000)
                mHandler.post {
                    findViewById<ImageView>(R.id.imageView_magicHide).visibility = View.VISIBLE
                    findViewById<ImageView>(R.id.imageView_magicBase).visibility = View.INVISIBLE
                }
            }.start()
        }
    }
}
