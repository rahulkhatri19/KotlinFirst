package `in`.khatri.rahul.kotlinfirst.fragment


import `in`.khatri.rahul.kotlinfirst.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_check_age.*
import kotlinx.android.synthetic.main.fragment_check_age.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class CheckAgeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_check_age, container, false)
        view.btnFindAge.setOnClickListener {
            val yearOfBirth: Int= et_dob.text.toString().toInt()
            val myAge= 2019 - yearOfBirth
            tv_show_age.text= "Your Age is $myAge years"
        }

        return view
    }

}
