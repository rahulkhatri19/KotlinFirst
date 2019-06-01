package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.MainActivity
import `in`.khatri.rahul.kotlinfirst.R
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.Button
import java.util.*

class TicTacToy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toy)
    }
    protected fun btnTicTac(view: View){
        val btnSelected = view as Button
        var cellID= 0
        when(btnSelected.id){
            R.id.btnTicTac1 -> cellID=1
            R.id.btnTicTac2 -> cellID=2
            R.id.btnTicTac3 -> cellID=3
            R.id.btnTicTac4 -> cellID=4
            R.id.btnTicTac5 -> cellID=5
            R.id.btnTicTac6 -> cellID=6
            R.id.btnTicTac7 -> cellID=7
            R.id.btnTicTac8 -> cellID=8
            R.id.btnTicTac9 -> cellID=9
        }
     //   Toast.makeText(this, "ID: "+cellID, Toast.LENGTH_SHORT).show()
        GameLogic(cellID, btnSelected)
    }
    var Player1= ArrayList<Int>()
    var Player2= ArrayList<Int>()
    var ActivePlayer=1
    fun GameLogic(cellId:Int, btnSelected: Button){
        if (ActivePlayer == 1){
            btnSelected.text="X"
            btnSelected.setBackgroundColor(Color.GRAY)
            Player1.add(cellId)
            ActivePlayer=2
           // AutoPlay()
        }else {
            btnSelected.text="0"
            btnSelected.setBackgroundColor(Color.BLUE)
            Player2.add(cellId)
            ActivePlayer=1
        }
        btnSelected.isEnabled= false
        FindWinner()
    }
    fun FindWinner(){
        var winner= -1
        // row 1
        if (Player1.contains(1)&& Player1.contains(2)&& Player1.contains(3)){
            winner=1
        }
        if (Player2.contains(1)&& Player2.contains(2)&& Player2.contains(3)){
            winner=2
        }
        // row 2
        if (Player1.contains(4)&& Player1.contains(5)&& Player1.contains(6)){
            winner=1
        }
        if (Player2.contains(4)&& Player2.contains(5)&& Player2.contains(6)){
            winner=2
        }
        // row 3
        if (Player1.contains(7)&& Player1.contains(8)&& Player1.contains(9)){
            winner=1
        }
        if (Player2.contains(7)&& Player2.contains(8)&& Player2.contains(9)){
            winner=2
        }

        // col 1
        if (Player1.contains(1)&& Player1.contains(4)&& Player1.contains(7)){
            winner=1
        }
        if (Player2.contains(1)&& Player2.contains(4)&& Player2.contains(7)){
            winner=2
        }
        // col 2
        if (Player1.contains(2)&& Player1.contains(5)&& Player1.contains(8)){
            winner=1
        }
        if (Player2.contains(2)&& Player2.contains(5)&& Player2.contains(8)){
            winner=2
        }
        // col 3
        if (Player1.contains(3)&& Player1.contains(6)&& Player1.contains(9)){
            winner=1
        }
        if (Player2.contains(3)&& Player2.contains(6)&& Player2.contains(9)){
            winner=2
        }
        // Diagonal 1
        if (Player1.contains(1)&& Player1.contains(5)&& Player1.contains(9)){
            winner=1
        }
        if (Player2.contains(1)&& Player2.contains(5)&& Player2.contains(9)){
            winner=2
        }
        // Diagonal 2
        if (Player1.contains(3)&& Player1.contains(5)&& Player1.contains(7)){
            winner=1
        }
        if (Player2.contains(3)&& Player2.contains(5)&& Player2.contains(7)){
            winner=2
        }

        if (winner != -1){
            if (winner==1){
              //  Toast.makeText(this,"Player 1 is Winner\n\nWould You like to play again",Toast.LENGTH_LONG).show()
                 AlertDialog.Builder(this@TicTacToy).setTitle("Winner").setMessage("Mr. Gray is Winner\n\nWould You like to play again").setPositiveButton("Yes"){
                    dialog, which ->
                    startActivity(Intent(this, TicTacToy::class.java))
                }.setNegativeButton("No"){
                    dialog, which ->
                    startActivity(Intent(this, MainActivity::class.java))
                }.create().show()
            }
            else{
              //  Toast.makeText(this,"Player 2 is Winner",Toast.LENGTH_LONG).show()
                AlertDialog.Builder(this@TicTacToy).setTitle("Winner").setMessage("Mr. Blue is Winner\n\nWould You like to play again").setPositiveButton("Yes"){
                    dialog, which ->
                    startActivity(Intent(this, TicTacToy::class.java))
                }.setNegativeButton("No"){
                    dialog, which ->
                    startActivity(Intent(this, MainActivity::class.java))
                }.create().show()
            }
        }
    }
    /*fun AutoPlay(){
        var emptyCell= ArrayList<Int>()
        for (cellID in 1..9){
            if (!(Player1.contains(cellID) || Player2.contains(cellID))){
                emptyCell.add(cellID)
            }
        }
        val random= Random()
        val randomIndex= random.nextInt(emptyCell.size-0)+0
        val cellId= emptyCell[randomIndex]

        var btnSelected:Button?
        when(cellId){
            1-> btnSelected= btnTicTac1
            2-> btnSelected= btnTicTac2
            3-> btnSelected= btnTicTac3
            4-> btnSelected= btnTicTac4
            5-> btnSelected= btnTicTac5
            6-> btnSelected= btnTicTac6
            7-> btnSelected= btnTicTac7
            8-> btnSelected= btnTicTac8
            9-> btnSelected= btnTicTac9
            else -> {
                btnSelected= btnTicTac1
            }
        }
        GameLogic(cellId, btnSelected)
    }*/
}
