package jwang.example.info6124lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SecondActivity : AppCompatActivity() {

    val TAG = "activity2"
    lateinit var gradeRecordList: ArrayList<GradeRecord>
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewManager: RecyclerView.LayoutManager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i(TAG, "starting")


        gradeRecordList= ArrayList<GradeRecord>()
        val sharedPreferences = getSharedPreferences("grade records", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("record", "")
        val type = object : TypeToken<ArrayList<GradeRecord>>() {}.type
        gradeRecordList = gson.fromJson(json,type)



        recyclerView = findViewById(R.id.recyclerViewRecords)
        recyclerViewManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerViewManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = RecyclerAdapter(gradeRecordList)

    }

    fun onButtonClick(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)



    }


}