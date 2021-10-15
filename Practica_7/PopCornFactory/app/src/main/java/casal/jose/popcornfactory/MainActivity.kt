package casal.jose.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import casal.jose.popcornfactory.Catalogo

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaración del botón
        val btnP: Button = findViewById(R.id.botonP)

        btnP.setOnClickListener{
            var intent: Intent = Intent(this,Catalogo::class.java)
            startActivity(intent)
        }
    }
}