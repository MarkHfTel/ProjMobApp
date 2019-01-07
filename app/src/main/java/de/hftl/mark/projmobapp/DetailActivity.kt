package de.hftl.mark.projmobapp

import android.hardware.Sensor
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent

class DetailActivity : AppCompatActivity(), RecyclerView.OnItemTouchListener {
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
        setContentView(R.layout.activity_details)

    }


    fun showDetails(sensors: List<Sensor>, position: Int) {
        Log.d("TEST:", "Folgendes wurde geklickt ${sensors.get(position).name}")
    }
}
