package casal.jose.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Se declaran todos los botones númericos.
    var btn0: Button = findViewById(R.id.btn0)
    var btn1: Button = findViewById(R.id.btn1)
    var btn2: Button = findViewById(R.id.btn2)
    var btn3: Button = findViewById(R.id.btn3)
    var btn4: Button = findViewById(R.id.btn4)
    var btn5: Button = findViewById(R.id.btn5)
    var btn6: Button = findViewById(R.id.btn6)
    var btn7: Button = findViewById(R.id.btn7)
    var btn8: Button = findViewById(R.id.btn8)
    var btn9: Button = findViewById(R.id.btn9)

    //Se declaran los botones de acciones
    var btnSum: Button = findViewById(R.id.btnSum)
    var btnRes: Button = findViewById(R.id.btnRes)
    var btnMul: Button = findViewById(R.id.btnMul)
    var btnDiv: Button = findViewById(R.id.btnDiv)
    var btnResult: Button = findViewById(R.id.btnResult)
    var btnReset: Button = findViewById(R.id.btnReset)

    //Se declaran los textView
    var tvAuxiliar: TextView = findViewById(R.id.tvAuxiliar)
    var tvResultado: TextView = findViewById(R.id.tvResult)

    //Se declaran las variables globales númericas
    var auxiliar1Num: Double = 0.0
    var auxiliar2Num: Double = 0.0
    var resultadoNum: Double = 0.0
    var operacion: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Empezamos a declarar los métodos oyentes de cada botón
        /**
         * Lógica del método oyende del botón: "0"
         */
        btn0.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "0"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("0")
            }
        }
        /**
         * Lógica del método oyende del botón: "1"
         */
        btn1.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0")) {
                val auxStr: String = this.tvAuxiliar.text.toString() + "1"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("1")
            }
        }
        /**
         * Lógica del método oyende del botón: "2"
         */
        btn2.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "2"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("2")
            }
        }
        /**
         * Lógica del método oyende del botón: "3"
         */
        btn3.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "3"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("3")
            }
        }
        /**
         * Lógica del método oyende del botón: "4"
         */
        btn4.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "4"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("4")
            }
        }
        /**
         * Lógica del método oyende del botón: "5"
         */
        btn5.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "5"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("5")
            }
        }
        /**
         * Lógica del método oyende del botón: "6"
         */
        btn6.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "6"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("6")
            }
        }
        /**
         * Lógica del método oyende del botón: "7"
         */
        btn7.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "7"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("7")
            }
        }
        /**
         * Lógica del método oyende del botón: "8"
         */
        btn8.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "8"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("8")
            }
        }
        /**
         * Lógica del método oyende del botón: "9"
         */
        btn9.setOnClickListener {
            if (!this.tvAuxiliar.text.toString().equals("0"))
            {
                val auxStr: String = this.tvAuxiliar.text.toString() + "9"
                tvAuxiliar.setText(auxStr)
            } else {
                this.tvAuxiliar.setText("9")
            }
        }
        /**
         * Lógica del método oyende del botón: "+"
         */
        btnSum.setOnClickListener{
            if(!this.tvAuxiliar.text.toString().equals("0"))
            {
                this.operacion = 1
                this.auxiliar1Num = this.tvAuxiliar.text.toString().toDouble()
                var auxStr: String = this.tvAuxiliar.text.toString()
                auxStr = auxStr + "+"
                this.tvResultado.setText(auxStr)
                this.tvAuxiliar.setText("0")
            }
        }
        /**
         * Lógica del método oyende del botón: "-"
         */
        btnRes.setOnClickListener{
            if(!this.tvAuxiliar.text.toString().equals("0"))
            {
                this.operacion = 2
                this.auxiliar1Num = this.tvAuxiliar.text.toString().toDouble()
                var auxStr: String = this.tvAuxiliar.text.toString()
                auxStr = auxStr + "-"
                this.tvResultado.setText(auxStr)
                this.tvAuxiliar.setText("0")
            }
            /**
             * Lógica del método oyende del botón: "*"
             */
            btnMul.setOnClickListener{
                if(!this.tvAuxiliar.text.toString().equals("0"))
                {
                    this.operacion = 3
                    this.auxiliar1Num = this.tvAuxiliar.text.toString().toDouble()
                    var auxStr: String = this.tvAuxiliar.text.toString()
                    auxStr = auxStr + "*"
                    this.tvResultado.setText(auxStr)
                    this.tvAuxiliar.setText("0")
                }
            }
            /**
             * Lógica del método oyende del botón: "/"
             */
            btnDiv.setOnClickListener{
                if(!this.tvAuxiliar.text.toString().equals("0"))
                {
                    this.operacion = 4
                    this.auxiliar1Num = this.tvAuxiliar.text.toString().toDouble()
                    var auxStr: String = this.tvAuxiliar.text.toString()
                    auxStr = auxStr + "/"
                    this.tvResultado.setText(auxStr)
                    this.tvAuxiliar.setText("0")
                }
            }
            /**
             * Lógica del método oyende del botón: "Result"
             */
            btnResult.setOnClickListener{
                if(!this.tvAuxiliar.text.toString().equals("0"))
                {
                    this.auxiliar2Num = this.tvAuxiliar.text.toString().toDouble()
                    when(operacion)
                    {
                        1 -> this.resultadoNum = this.suma(this.auxiliar1Num, this.auxiliar2Num)
                        2 -> this.resultadoNum = this.resta(this.auxiliar1Num, this.auxiliar2Num)
                        3 -> this.resultadoNum = this.mult(this.auxiliar1Num, this.auxiliar2Num)
                        4 -> this.resultadoNum = this.div(this.auxiliar1Num, this.auxiliar2Num)
                    }
                    this.tvResultado.setText(this.resultadoNum.toString())
                    this.tvAuxiliar.setText("0")
                }
            }
            /**
             * Lógica del método oyende del botón: "Reset"
             */
            btnReset.setOnClickListener{
                this.reset()
            }
        }
    }
    /**
     * Función encargada de sumar dos valores
     */
    fun suma(num1: Double,num2: Double): Double{
        return (num1 + num2)
    }

    /**
     * Función encargada de restar dos valores
     */
    fun resta(num1: Double,num2: Double): Double{
        return (num1 - num2)
    }

    /**
     * Función encargada de multiplicar 2 valores
     */
    fun mult(num1: Double,num2: Double): Double{
        return (num1 * num2)
    }

    /**
     * Función que se encarga de dividir dos valores
     */
    fun div(num1: Double,num2: Double): Double{
        return (num1 / num2)
    }

    /**
     * Función encargada de reiniciar a los valores
     * por defecto
      */
    fun reset(){
        this.tvAuxiliar.setText("0")
        this.tvResultado.setText("")
        this.auxiliar1Num = 0.0
        this.auxiliar2Num = 0.0
        this.resultadoNum = 0.0
        this.operacion = -1
    }
}