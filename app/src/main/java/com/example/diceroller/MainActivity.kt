package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {


            rollDice()


        }
        // Muestra un dado al inicio
        rollDice()

    }

    private fun rollDice() {

        val dice = Dice(6)

        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

       //** if (diceRoll == 1) {
       //     diceImage.setImageResource(R.drawable.dice_1)
       // } else if (diceRoll == 2) {
       //     diceImage.setImageResource(R.drawable.dice_2)
       // } else if (diceRoll == 3) {
       //     diceImage.setImageResource(R.drawable.dice_3)
       // } else if (diceRoll == 4) {
       //     diceImage.setImageResource(R.drawable.dice_4)
       // } else if (diceRoll == 5) {
       //   diceImage.setImageResource(R.drawable.dice_5)
       // } else {
       //     diceImage.setImageResource(R.drawable.dice_6)
       // }
   // when (diceRoll) {
   //     1 ->diceImage.setImageResource(R.drawable.dice_1)
   //     2 ->diceImage.setImageResource(R.drawable.dice_2)
   //     3 ->diceImage.setImageResource(R.drawable.dice_3)
   //     4 ->diceImage.setImageResource(R.drawable.dice_4)
   //     5 ->diceImage.setImageResource(R.drawable.dice_5)
   //     6 ->diceImage.setImageResource(R.drawable.dice_6)
   // }
val drawableResource = when (diceRoll) {
    1 -> R.drawable.dice_1
    2 -> R.drawable.dice_2
    3 -> R.drawable.dice_3
    4 -> R.drawable.dice_4
    5 -> R.drawable.dice_5
    else -> R.drawable.dice_6
}
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 * Se crea la clase Dice (dado), con una variable llamada numSides, del tipo Int.
 */
class Dice(private val numSides: Int) {
    // La función roll, del tipo Int, muestra un número entero aleatorio entre 0 y el valor de numSides
    fun roll(): Int {
        return (0..numSides).random()
    }
}