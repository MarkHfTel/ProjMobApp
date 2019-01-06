package de.hftl.mark.projmobapp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SharedPref: AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val inputText = findViewById<EditText>(R.id.editText_shared)
        val message = inputText.text.toString()
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)?:return
        with(sharedPref.edit()){
            putString("user_input",message)
            apply()
        }
        findViewById<TextView>(R.id.textViewShared).text = message
        findViewById<TextView>(R.id.textViewForget).text = message
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("YYYYYY:","Shared Aufgerufen")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        findViewById<TextView>(R.id.textViewShared).text = this.getPreferences(Context.MODE_PRIVATE)?.getString("user_input", "-leer-")
    }
}
