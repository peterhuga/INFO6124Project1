package jwang.example.info6124lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {



    //var recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecords)
    //var recyclerAdapter: RecyclerAdapter = RecyclerAdapter(gradeRecordList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



//Testing intent sending GradeRecord object
        val record = intent.extras?.get("extra_object") as Object
        val displayText = findViewById<TextView>(R.id.textView7)
        displayText.text = record.toString()
    }

    fun onButtonClick(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)



    }


}