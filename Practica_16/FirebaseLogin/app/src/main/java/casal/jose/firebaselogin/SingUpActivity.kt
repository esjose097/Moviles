package casal.jose.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import casal.jose.firebaselogin.databinding.ActivitySingUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class SingUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.signUpButton.setOnClickListener {
            val eMail = binding.emailEditText.text.toString()
            val mPassword = binding.passwordEditText.text.toString()
            val mRepeatPassword = binding.repeatPasswordEditText.text.toString()
            val passwordRegex = Pattern.compile("^" + "(?=.*[-@#$%^&+=])" + ".{6,}" + "$")

            if(eMail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(eMail).matches())
            {
                Toast.makeText(this,"Ingrese un email valido",
                Toast.LENGTH_SHORT).show()
            }
            else if(mPassword.isEmpty() || !passwordRegex.matcher(mPassword).matches())
            {
                Toast.makeText(this, "La contraseña es debil.",
                Toast.LENGTH_SHORT).show()
            }
            else if(mPassword != mRepeatPassword)
            {
                Toast.makeText(this, "Confirma la contraseña.",
                Toast.LENGTH_SHORT).show()
            }
            else
            {
                createAccount(eMail, mPassword)
            }
        }

        binding.backImageView.setOnClickListener {
            val intent = Intent(this, SingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password:String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if(task.isSuccessful)
            {}
            else
            {
                Log.w("TAG","createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}