package casal.jose.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class detalle_pelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        //Valores por defecto
        var id = -1
        var title: String = ""
        var seats = 20

        var seafLeft: TextView = findViewById(R.id.seafLeft)
        var tv_nombre_pelicula: TextView = findViewById(R.id.tv_nombre_pelicula) as TextView
        var iv_pelicula_imagen: ImageView = findViewById(R.id.iv_pelicula_imagen) as ImageView
        var tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc) as TextView
        var btnBuyTickets: Button = findViewById(R.id.btnBuyTickets)
        seafLeft.setText("Seaf Left: $seats")

        val bundle = intent.extras
        if(bundle!=null)
        {
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            id = bundle.getInt("pos")
            /*La linea num 35 no me convence del todo si truena va por aquí*/
            title = bundle.getString("titulo") as String
        }

        btnBuyTickets.setOnClickListener{
            val intent: Intent = Intent(this, SeatSelection::class.java)
            intent.putExtra("id", id)
            intent.putExtra("name", title)
            startActivity(intent)
        }
    }
}