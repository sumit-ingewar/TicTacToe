package sumit.com.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareButton()
    }


    override fun onClick(view: View?) {


        val selectedButton = view as Button
        var cellId = 0

        when (view.id) {

            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        playGame(cellId, selectedButton)


    }

    protected fun prepareButton() {

        bu1.setOnClickListener(this)
        bu2.setOnClickListener(this)
        bu3.setOnClickListener(this)
        bu4.setOnClickListener(this)
        bu5.setOnClickListener(this)
        bu6.setOnClickListener(this)
        bu7.setOnClickListener(this)
        bu8.setOnClickListener(this)
        bu9.setOnClickListener(this)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1;

    fun playGame(cellId: Int, selectedButton: Button) {

        if (activePlayer == 1) {

            selectedButton.setText("X")
            selectedButton.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
        } else {

            selectedButton.setText("O")
            selectedButton.setBackgroundColor(Color.CYAN)
            player2.add(cellId)
            activePlayer = 1
        }

        selectedButton.isEnabled = false;

        if (player1.size >= 3 || player2.size >= 3) {
            checkWinner()
        }
    }


    private fun checkWinner() {

        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(9) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 won the game", Toast.LENGTH_SHORT).show()
            } else if (winner == 2) {
                Toast.makeText(this, "Player 2 won the game", Toast.LENGTH_SHORT).show()
            }
        }


    }


}
