package casal.jose.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Se declara el botón sing in
        val btnSingIn:Button= findViewById(R.id.btn_sing_in)

        btnSingIn.setOnClickListener {
            var intent: Intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }
}