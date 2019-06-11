package `in`.khatri.rahul.kotlinfirst.fragment


import `in`.khatri.rahul.kotlinfirst.R
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import kotlinx.android.synthetic.main.fragment_check_age.*
import kotlinx.android.synthetic.main.fragment_check_age.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 *
 */
class CheckAgeFragment : Fragment() {
    var cal = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_check_age, container, false)
        view.btnFindAge.setOnClickListener {
            val yearOfBirth: Int = et_dob.text.toString().toInt()
            val myAge = 2019 - yearOfBirth
            tv_show_age.text = "Your Age is $myAge years"
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                Log.e("year: $year month $month", "day: $dayOfMonth")

            }

        }
        view.et_dob.setOnClickListener {
            DatePickerDialog(activity, dateSetListener, cal.get(Calendar.YEAR),  cal.get(Calendar.MONTH),  cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        return view
    }
// // create an OnDateSetListener
//        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
//                                   dayOfMonth: Int) {
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInView()
//            }

//     // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
//        button_date!!.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View) {
//                DatePickerDialog(this@MainActivity,
//                        dateSetListener,
//                        // set DatePickerDialog to point to today's date when it loads up
//                        cal.get(Calendar.YEAR),
//                        cal.get(Calendar.MONTH),
//                        cal.get(Calendar.DAY_OF_MONTH)).show()
//            }
//
//        })
}
