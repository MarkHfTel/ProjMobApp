package de.hftl.mark.projmobapp

import android.hardware.Sensor
import android.support.v7.app.AppCompatActivity
import android.util.Log

class DetailActivity : AppCompatActivity() {

    fun showDetails(sensors: List<Sensor>, position: Int) {
        Log.d("TEST:", "Folgendes wurde geklickt ${sensors.get(position).name}")
    }
}
