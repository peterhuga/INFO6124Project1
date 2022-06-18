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



    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewManager: RecyclerView.LayoutManager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var gradeRecordList: ArrayList<GradeRecord> = ArrayList<GradeRecord>()
        val sharedPreferences = getSharedPreferences("grade records", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("record", "")
        val type = object : TypeToken<ArrayList<GradeRecord>>() {}.type
        gradeRecordList = gson.fromJson(json,type)
        val textViewCounter: TextView = findViewById(R.id.textViewCounter)



        recyclerView = findViewById(R.id.recyclerViewRecords)
        recyclerViewManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerViewManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = RecyclerAdapter(gradeRecordList)

        val counterText: String = getString (R.string.counter_text) + " " + RecyclerAdapter(gradeRecordList).itemCount.toString()
        textViewCounter.text =counterText



    }

    fun onButtonClick(view: View) {
        finish()



    }


}