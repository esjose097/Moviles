package casal.jose.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //Variables globales
    var minValue = 0
    var maxValue = 100
    var num: Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instancia al objeto del layout guessing
        val guessing: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        //Método de click al botón generate
        generate.setOnClickListener {
            num = Random.nextInt(minValue - maxValue)
            guessing.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.INVISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if(this.chekingLimits())
            {
                num = Random.nextInt(minValue - maxValue)
                guessing.setText(num.toString())
            }
            else
            {
                guessing.setText("No puede ser, ganaste")
            }
        }

        down.setOnClickListener{
            maxValue = num
            if(this.chekingLimits())
            {
                num = Random.nextInt(minValue - maxValue)
                guessing.setText(num.toString())
            }
            else
            {
                guessing.setText("No puede ser, ganaste!")
            }
        }

        guessed.setOnClickListener{
            if(!won)
            {
                guessing.setText("Adiviné tu número es el: "+num)
                guessed.setText("Volver a jugar")
                won=true
            }
            else
            {
                generate.visibility=View.VISIBLE
                guessing.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                this.resetValues()
            }
        }
    }
    /*
    Función encargada de revisar si el valor mínimo
     no es igual que el máximo
     */
    fun chekingLimits(): Boolean{
        return minValue != maxValue
    }
    /*
    Función encargada de reiniciar a los valores inciales las
    variables.
     */
    fun resetValues(){
        minValue = 0
        maxValue = 100
        num = 0
        won = false
    }
}