package casal.jose.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)
        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1
        var movieTitle = ""

        val bundle = intent.extras

        if(bundle != null)
        {

            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
            movieTitle = bundle.getString("name") as String
        }

        val btnConfirm: Button = findViewById(R.id.btnConfirm)

        btnConfirm.setOnClickListener{

            var seatsS: Int = this.seat_selection()
            intent.putExtra("seat", seatsS)
            intent.putExtra("movieTitle", movieTitle)

            Toast.makeText(this, "Enjoy your movie! :D the number of seats it's: $seatsS", Toast.LENGTH_LONG).show()
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener{group, chekedId ->
            if(chekedId > -1)
            {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(chekedId)
            }
        }
        row2.setOnCheckedChangeListener{group, chekedId ->
            if(chekedId > -1)
            {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(chekedId)
            }
        }
        row3.setOnCheckedChangeListener{group, chekedId ->
            if(chekedId > -1)
            {
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(chekedId)
            }
        }
        row4.setOnCheckedChangeListener{group, chekedId ->
            if(chekedId > -1)
            {
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(chekedId)
            }
        }
    }

    /*Sesupone que me devuelve el número de asiento seleccionado.*/
    fun seat_selection(): Int{
        var seats = 0
        var aux = 20
        for(i in 0 until 20)
        {
            var radioId: String = "btnR"+(i+1)
            var resID: Int = resources.getIdentifier(radioId,"id",packageName)
            var radio: RadioButton = findViewById(resID)
            if(radio.isChecked || radio.isEnabled == false)
            {
                aux--
                /*
                Intentaba que desactivara los botones ya seleccionados pero la practica
                no es muy clara en ese sentido por lo cual decidí decidí implementarlo
                radio.isEnabled = false
                */
                radio.isEnabled = false
            }
        }
        return aux
    }
}