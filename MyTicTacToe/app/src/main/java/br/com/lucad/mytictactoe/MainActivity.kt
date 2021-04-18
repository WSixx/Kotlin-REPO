package br.com.lucad.mytictactoe

import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View){
        val btnSelected = view as Button
        var cellId = 0
        when(btnSelected.id){
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        //Log.d("btnClick: " , btnSelected.id.toString())
        //Log.d("btnClick: cellId: " , cellId.toString())

        playGame(cellId, btnSelected)

    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    private fun playGame(cellId: Int, btnSelect:Button ){
        if(activePlayer == 1){
            btnSelect.text = "X"
            btnSelect.setBackgroundResource(R.color.blue)
            activePlayer = 2
        }else{
            btnSelect.text = "O"
            btnSelect.setBackgroundResource(R.color.darkGreen)
            activePlayer = 1

        }
    }

}