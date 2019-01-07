package de.hftl.mark.projmobapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_details.*

class DetailActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var mSensorManager: SensorManager
    private var mSensor: Sensor? = null

    override fun onSensorChanged(event: SensorEvent?) {
        if (mSensor?.name.equals(event?.sensor?.name))
            senValue.text = event!!.values[0].toString()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("YYYY", "Hallo Details")
        setContentView(R.layout.activity_details)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        val intent = intent
        val x = intent.getIntExtra("position", 0)
        Log.d("YYYY", "Finished? $x")
        mSensor = sensors[x]

        senName.text = mSensor?.name
        senPrecision.text = mSensor?.resolution.toString()
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }
}
