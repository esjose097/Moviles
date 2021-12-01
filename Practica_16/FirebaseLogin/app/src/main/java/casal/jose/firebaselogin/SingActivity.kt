package casal.jose.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import casal.jose.firebaselogin.databinding.ActivitySingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SingActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing)

        binding = ActivitySingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize Firebase Auth
        auth = Firebase.auth

        binding.signInAppCompatButton.setOnClickListener{
            val eMail = binding.emailEditText.text.toString()
            val mPass = binding.passwordEditText.text.toString()

            when
            {
                eMail.isEmpty() || mPass.isEmpty() ->{
                    Toast.makeText(baseContext, "Correo o contraseña incorrecto.",
                    Toast.LENGTH_SHORT).show()
                }else ->{
                    SingIn(eMail,mPass)
                }
            }
        }
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this,SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun SingIn(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful)
                {
                    Log.d("TAG","singInWithEmail:success")
                    reload()
                }
                else
                {
                    Log.w("TAG","singInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun reload(){
        val intent= Intent(this,SingActivity::class.java)
        this.startActivity(intent)
    }
}