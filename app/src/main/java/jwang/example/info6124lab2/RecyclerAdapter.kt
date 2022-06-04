package jwang.example.info6124lab2

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val dataSet: ArrayList<GradeRecord>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewCourseName: TextView
        val textViewGradeType: TextView
        val textViewFullGrade: TextView
        val textViewRcvGrade: TextView
        val textViewPercentage: TextView
        val cardView: LinearLayout

        init {
            textViewCourseName = view.findViewById(R.id.courseNameRvTxt)
            textViewGradeType = view.findViewById(R.id.gradeTypeRvTxt)
            textViewFullGrade = view.findViewById(R.id.fullGradeRvTxt)
            textViewRcvGrade = view.findViewById(R.id.rcvGradeRvTxt)
            textViewPercentage = view.findViewById(R.id.percentageRvTxt)
            cardView = view.findViewById(R.id.cardView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false )
        val lp = view.getLayoutParams()
        lp.height = 310

        view.setLayoutParams(lp)


        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textViewCourseName.text = "Course Name: " + dataSet[position].courseName
        holder.textViewGradeType.text = "Grade Type: " + dataSet[position].gradeType
        holder.textViewFullGrade.text = "Full Grade: " +  dataSet[position].fullGrade
        holder.textViewRcvGrade.text = "Received Grade: " + dataSet[position].receivedGrade
        holder.textViewPercentage.text = "Weight In Course: " + dataSet[position].percentage + "%"

        when(dataSet[position].courseName) {

            "INFO6124" -> {holder.cardView.setBackgroundColor(Color.GREEN)}
            "INFO6125" -> {holder.cardView.setBackgroundColor(Color.RED)}
            "INFO6126" -> {holder.cardView.setBackgroundColor(Color.BLUE)}
            "INFO6127" -> {holder.cardView.setBackgroundColor(Color.GRAY)}
            "INFO6128" -> {holder.cardView.setBackgroundColor(Color.MAGENTA)}
            "INFO6129" -> {holder.cardView.setBackgroundColor(Color.BLACK)}
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}