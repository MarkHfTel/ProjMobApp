package de.hftl.mark.projmobapp

import android.hardware.Sensor
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.)
    }

    public fun showDetails(sensors : List<Sensor>, position: Int){
        Log.d("TEST:", "Folgendes wurde geklickt ${sensors.get(position).name}")
    }
}
