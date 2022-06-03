package jwang.example.info6124lab2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var spinnerValue: String
    lateinit var radioGroup: RadioGroup
    lateinit var fullGradeText: EditText
    lateinit var rcvGradeText: EditText
    lateinit var percText: EditText
    lateinit var topText: TextView
    val gradeRecordList: MutableList<GradeRecord> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        topText = findViewById(R.id.textView)

        radioGroup = findViewById(R.id.radioGroup)
        fullGradeText = findViewById((R.id.fullGradeEditText))
        rcvGradeText = findViewById(R.id.rcvGradeEditText)
        percText = findViewById(R.id.percEditText)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.courses,
            android.R.layout.simple_gallery_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

    }

    fun onButtonClick(view: View) {

        when(view.id) {
            R.id.recordButton -> {


                var gr = GradeRecord(
                    spinnerValue,
                    "lab",
                    "100",
                    "70",
                    "5%"
                )
                gradeRecordList.add(gr)
                topText.text = gradeRecordList.toString()
//                adapter.notifyItemInserted(courseModalArrayList.size());
                val sharedPreferences = getSharedPreferences("grade records", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val gson = Gson()
                val json: String = gson.toJson(gradeRecordList)
                editor.putString("grade", json)
                editor.apply()

                Toast.makeText(this, "Grade record saved.", Toast.LENGTH_LONG).show()



            }

//            R.id.descButton -> {
//
//            }
       }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
          spinnerValue = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}


}