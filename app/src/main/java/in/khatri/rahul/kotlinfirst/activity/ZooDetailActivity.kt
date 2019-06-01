package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_zoo_detail.*

class ZooDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoo_detail)
        Log.e("name", intent.getStringExtra("name"))
        tv_name.text = intent.getStringExtra("name")
        tv_des.text = intent.getStringExtra("des")
        iv_animal_image.setImageResource(intent.getIntExtra("image",R.drawable.panda))
    }
}
