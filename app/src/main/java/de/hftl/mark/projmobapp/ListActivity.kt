package de.hftl.mark.projmobapp

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent

class ListActivity : AppCompatActivity(), SensorEventListener {
    override fun onSensorChanged(event: SensorEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mSensorManager: SensorManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        val senList = ArrayList<String>()
        for (x in sensors) {
            senList.add(x.name)
        }
        viewManager = LinearLayoutManager(this)
        viewAdapter = SenAdapter(senList)

        recyclerView = findViewById<RecyclerView>(R.id.recList).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }
}