package de.hftl.mark.projmobapp

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View


//Funktioniert bis zum Click-Event gut, dann ist glaube ich der Context das Problem, dass die Applikation zum Stehen bringt.
class ListActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        Log.d("YYYY", "Hallo $v")
    }
    fun onClick(v: View?, pos : Int){
        Log.d("YYYY", "Hallo $pos")
        val intent = Intent(this, DetailActivity::class.java)
        Log.d("YYYY", "Hab ich Context?")
        intent.putExtra("position", pos)
        startActivity(intent)
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

}