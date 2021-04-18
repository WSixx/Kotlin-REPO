package br.com.lucad.mytictactoe

import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import br.com.lucad.mytictactoe.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, btnSelect:Button? ){
        if(activePlayer == 1){
            btnSelect?.text = "X"
            btnSelect?.setBackgroundResource(R.color.blue)
            activePlayer = 2
            autoPlay()
        }else{
            btnSelect?.text = "O"
            btnSelect?.setBackgroundResource(R.color.darkGreen)
            activePlayer = 1

        }
        btnSelect?.isEnabled = false

        checkWinner()
    }

    private fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        var r = Random
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var btnSelected: Button? = when(cellId){
            1-> binding.btn1
            2-> binding.btn2
            3-> binding.btn3
            4-> binding.btn4
            5-> binding.btn5
            6-> binding.btn6
            7-> binding.btn7
            8-> binding.btn8
            9-> binding.btn9
            else -> {binding.btn1}
        }
        playGame(cellId, btnSelected )
    }

    private fun checkWinner() {
        var winner = -1

        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //diag
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(winner == 1){
            player1WinsCounts += 1
            Toast.makeText(this, "Player 1 is the Winner", Toast.LENGTH_LONG).show()
            restartGame()
        }else if(winner == 2){
            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 is the Winner", Toast.LENGTH_LONG).show()
            restartGame()
        }

    }

    var player1WinsCounts = 0
    var player2WinsCounts = 0

    private fun restartGame(){
        activePlayer = 1
        player1.clear()
        player2.clear()


        for(cellId in 1..9){
            var btnSelected: Button? = when(cellId){
                1-> binding.btn1
                2-> binding.btn2
                3-> binding.btn3
                4-> binding.btn4
                5-> binding.btn5
                6-> binding.btn6
                7-> binding.btn7
                8-> binding.btn8
                9-> binding.btn9
                else -> {binding.btn1}
            }
            btnSelected!!.text = ""
            btnSelected!!.setBackgroundResource(R.color.white)
            btnSelected!!.isEnabled = true

        }
        Toast.makeText(this, "Player1 : $player1WinsCounts | Player2 : $player2WinsCounts", Toast.LENGTH_LONG).show()
    }

}