package de.hftl.mark.projmobapp

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class DetailActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var mSensorManager: SensorManager

    //val sensors = mSensorManager.getSensorList()
    override fun onSensorChanged(event: SensorEvent?) {
        //Werte auslesen
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("YYYY", "Hallo Details")
        setContentView(R.layout.activity_details)
        val intent = getIntent()
        val x = intent.getIntExtra("position", 0)
        //senName.text = intent.extras["name"].toString()
        //senPrecision.text = intent.extras["reso"].toString()
    }
}
