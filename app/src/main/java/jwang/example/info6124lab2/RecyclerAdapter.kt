package jwang.example.info6124lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        init {
            textViewCourseName = view.findViewById(R.id.courseNameRvTxt)
            textViewGradeType = view.findViewById(R.id.gradeTypeRvTxt)
            textViewFullGrade = view.findViewById(R.id.fullGradeRvTxt)
            textViewRcvGrade = view.findViewById(R.id.rcvGradeRvTxt)
            textViewPercentage = view.findViewById(R.id.percentageRvTxt)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false )
        val lp = view.getLayoutParams()
        lp.height = 512
        view.setLayoutParams(lp)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewCourseName.text = dataSet[position].courseName
        holder.textViewGradeType.text = dataSet[position].gradeType
        holder.textViewFullGrade.text = dataSet[position].fullGrade
        holder.textViewRcvGrade.text = dataSet[position].receivedGrade
        holder.textViewPercentage.text = dataSet[position].percentage
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}