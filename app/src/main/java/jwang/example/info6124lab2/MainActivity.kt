package jwang.example.info6124lab2

import android.app.ProgressDialog.show
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var spinnerValue: String
    lateinit var radioGroup: RadioGroup
    lateinit var fullGradeText: EditText
    lateinit var rcvGradeText: EditText
    lateinit var percText: EditText
    lateinit var topText: TextView
    private var gradeRecordList: MutableList<GradeRecord> = ArrayList<GradeRecord>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        spinner = findViewById(R.id.spinner)
        topText = findViewById(R.id.textView)

        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.check(R.id.rButtonLab)
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

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("grade records", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("record", "")
        val type = object : TypeToken<ArrayList<GradeRecord>>() {}.type
        gradeRecordList = gson.fromJson(json,type)

    }





    fun onButtonClick(view: View) {

        when(view.id) {
            R.id.recordButton -> {
//Collect input from UI
                val selectedRdId: Int = radioGroup.checkedRadioButtonId
                val rdValue = findViewById<RadioButton>(selectedRdId).text.toString()
                val fullGrade = fullGradeText.text.toString()
                val rcvGrade = rcvGradeText.text.toString()
                val percentage = percText.text.toString()
//Build a data object with the collected data
                var gr = GradeRecord(
                    spinnerValue,
                    rdValue,
                    fullGrade,
                    rcvGrade,
                    percentage
                )
//Append the data object to the list
                gradeRecordList.add(gr)

//                adapter.notifyItemInserted(gradeRecordList.size());
//Write the list into shared pref
                val sharedPreferences = getSharedPreferences("grade records", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val gson = Gson()
                val json: String = gson.toJson(gradeRecordList)
                editor.putString("record", json)
                editor.apply()
//Toast a message to let the user know
                Toast.makeText(this, "Grade record saved.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, SecondActivity::class.java).apply { }
                startActivity(intent)
            }

            R.id.descButton -> {
                val intent = Intent(this, ThirdActivity::class.java).apply { }

                startActivity(intent)
            }
       }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
          spinnerValue = p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}


}