package casal.jose.asignacion4_calculadora_imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //Declaración de variables
    var txtResultado: TextView = findViewById(R.id.tvResultado)
    var txtEstado: TextView = findViewById(R.id.tvEstado)
    //Declaración de los editText
    val etEstatura: EditText = findViewById(R.id.etEstatura)
    val etPeso: EditText = findViewById(R.id.etPeso)
    val btnCalcula: Button = findViewById(R.id.btnCalcular)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lógica del botón cálcula
        btnCalcula.setOnClickListener{
            if(!this.etEstatura.text.isBlank() || !this.etPeso.text.isBlank())
            {
                //Se calcula el indice de masa corporal y se ubica el resultado en
                val imcNum = this.calculaIMC(this.etEstatura.text.toString().toDouble(),
                this.etPeso.text.toString().toDouble())
                this.txtResultado.setText(imcNum.toString())
                //Se obtiene el estado del usuario
                val estado = this.obtenEstado(imcNum)
                this.txtEstado.setText(estado)
                //Se le añade el color dependiendo del resultado
                when(estado)
                {
                    "Bajo peso" -> this.txtEstado.setBackgroundResource(R.color.colorBrown)
                    "Saludable" -> this.txtEstado.setBackgroundResource(R.color.colorGreen)
                    "Sobrepeso" -> this.txtEstado.setBackgroundResource(R.color.colorGreenish)
                    "Obesidad de grado 1" -> this.txtEstado.setBackgroundResource(R.color.colorYellow)
                    "Obesidad de grado 2" -> this.txtEstado.setBackgroundResource(R.color.colorOrange)
                    "Obesidad de grado 3" -> this.txtEstado.setBackgroundResource(R.color.colorRed)
                }
            }
        }
    }

    /**
     * Función encargada de calcular el imc en base
     * la altura y peso del usuario.
     */
    fun calculaIMC(altura: Double, peso: Double): Double{
        val imc: Double = (peso /(Math.pow(altura, 2.0)))
        return imc
    }

    /**
     * Función encargada de devolver el estado del usuario en base
     * al imc
     */
    fun obtenEstado(imc: Double): String{
        when
        {
            imc <18.5 -> return "Bajo peso"
            imc >= 18.5 && imc <=24.9 -> return "Saludable"
            imc > 24.9 && imc <= 29.9 -> return "Sobrepeso"
            imc > 29.9 && imc <= 34.9 -> return "Obesidad de grado 1"
            imc >34.9 && imc <= 39.9 -> return "obesidad de grado 2"
            imc >= 40 -> return "Obesidad de grado 3"
        }
        return "error"
    }
}