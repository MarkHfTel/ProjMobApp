package de.hftl.mark.projmobapp

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.SimpleCursorAdapter

private val FROM_COLUMNS: Array<String> = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
private val TO_IDS: IntArray = intArrayOf(android.R.id.text1)

class ContactList : AppCompatActivity() { //,LoaderManager.LoaderCallbacks<Cursor> {
    private val PERMISSION_REQUEST_CONTACTS = 123
    var mContactId: Long = 0
    var mKontactKey: String? = null
    var mContactUri: Uri? = null
    private val mCursorAdapter: SimpleCursorAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onStart() {
        super.onStart()
        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf<String>(android.Manifest.permission.READ_CONTACTS), PERMISSION_REQUEST_CONTACTS)
        } else
            doIt()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if ((requestCode == PERMISSION_REQUEST_CONTACTS) && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            doIt()
    }

    private fun doIt() {
        Log.d("YYYY", "Contact Part is loading.")
        val cList = ArrayList<String>()
        val mainQueryProjection = arrayOf(ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME)
        val mainQuerySelection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = ?"
        val mainQuerySelectionArgs = arrayOf("1")
        val mainQueryCursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            mainQueryProjection,
            mainQuerySelection,
            mainQuerySelectionArgs,
            null
        )
        for (x in mainQueryProjection) {
            Log.d("YYYY", "$x")
        }


        if (mainQueryCursor != null) {
            while (mainQueryCursor.moveToNext()) {
                var contactID = mainQueryCursor.getString(0)
                var displayName = mainQueryCursor.getString(1)
                Log.d("YYYY", "$displayName")
                cList.add(displayName)
            }
            mainQueryCursor.close()
        }
        provideContent(cList)
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private fun provideContent(cList: ArrayList<String>) {
        viewAdapter = SenAdapter(cList)
        viewManager = LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.recList).apply{
            layoutManager = viewManager
            adapter = viewAdapter
        }


    }

}
