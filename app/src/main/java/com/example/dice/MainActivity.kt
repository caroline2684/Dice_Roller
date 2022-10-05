package com.example.dice

import android.os.Build.ID
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*busqueda de elementos por ID*/
        val rollButton: Button = findViewById(R.id.button)
        //setOnClickListener(): el objeto escucha una llamada de clicks
        rollButton.setOnClickListener {
            /*toast: es una vista que contiene un pequeño mensaje rápido para el usuario*/
            val toast= Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT)
            toast.show()
            rollButton.setOnClickListener { rollDice() }
            rollDice()
        }
    }

    private fun rollDice() {
        //dado de 6 caras
        val dice = Dice(6)
        val diceRoll = dice.roll()
        /*busca el TextView por ID
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()*/
        //establecer el valor de la imagen
        val diceImage: ImageView = findViewById(R.id.imageView)
        //para seleccionar el dado se que muestre en base al número
        //Optimizacion de codigo para no repetir la misma linea
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Actualice ImageView con el ID de recurso dibujable correcto
        diceImage.setImageResource(drawableResource)
        //Actualizar el contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}
//agregamos la clase Dice
class Dice(val numSides: Int){
    fun roll():Int{
        //retorna un numero del 1 al numero de lados aleatoriamente
        return (1..numSides).random()
    }
}