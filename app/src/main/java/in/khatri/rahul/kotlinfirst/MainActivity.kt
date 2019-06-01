package `in`.khatri.rahul.kotlinfirst

import `in`.khatri.rahul.kotlinfirst.activity.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var toggle: ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawer_layout.addDrawerListener(toggle!!)
        toggle!!.setToolbarNavigationClickListener {
            onSupportNavigateUp()
        }
        toggle!!.syncState()

        navigation_view.setNavigationItemSelectedListener(this)

// toggle.isDrawerIndicatorEnabled = true
//        toggle!!.isDrawerIndicatorEnabled= true

        /* btn_find_age.setOnClickListener {
             startActivity(Intent(this, Test::class.java))
         }
         btn_tic_tac_toy.setOnClickListener {
             startActivity(Intent(this, TicTacToy::class.java))
         }
         btn_calculator.setOnClickListener {
             startActivity(Intent(this, CalculatorActivity::class.java))
         }
         btn_pockemon.setOnClickListener {
             startActivity(Intent(this, PokemonGameActivity::class.java))
         }
         btn_zoo_app.setOnClickListener {
             startActivity(Intent(this, ZooActivity::class.java))
         }*/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.find_age -> {
                startActivity(Intent(this, Test::class.java))
//                Toast.makeText(this,"Find Age Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.tic_tac -> {
                startActivity(Intent(this, TicTacToy::class.java))
//                Toast.makeText(this,"Tic Tac Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.calculator -> {
                startActivity(Intent(this, CalculatorActivity::class.java))
//                Toast.makeText(this,"Calculator Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.pokemon -> {
                startActivity(Intent(this, PokemonGameActivity::class.java))
//                Toast.makeText(this,"Pokemon Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.zoo -> {
                startActivity(Intent(this, ZooActivity::class.java))
//                Toast.makeText(this,"Zoo Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.food -> {
                startActivity(Intent(this, RestaurantActivity::class.java))
            }


        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
