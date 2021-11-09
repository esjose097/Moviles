package casal.jose.mis_notas

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

class AgregaNotaActivity : AppCompatActivity() {
    val etTitulo: EditText = findViewById(R.id.et_titulo)
    val etContenido: EditText = findViewById(R.id.et_contenido)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agrega_nota)

        val btnG:Button = findViewById(R.id.btn_guardar)

        btnG.setOnClickListener{
            guardarNota()
        }
    }
    fun guardarNota(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            235)
        }
        else{}
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode)
        {
            235 ->{
                if((grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    guardar()
                }
                else{
                    Toast.makeText(this,"Error: permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun guardar(){
        var titulo = etTitulo.text.toString()
        var contenido = etContenido.text.toString()

        if(titulo == "" || contenido == "")
        {
            Toast.makeText(this,"Error: Campos vacíos",Toast.LENGTH_SHORT).show()
        }
        else
        {
            try {
                val archivo = File(ubicacion(),titulo+".txt")
                val fos = FileOutputStream(archivo)
                fos.write(contenido.toByteArray())
                fos.close()
                Toast.makeText(this,"Se guardó el archivo en la carpeta pública",Toast.LENGTH_SHORT).show()
            }
            catch (e:Exception)
            {
                Toast.makeText(this,"Error: No se guardó el archivo",Toast.LENGTH_SHORT).show()
            }
            catch (e:java.lang.Exception)
            {
                Toast.makeText(this,"Error: No se guardó el archivo",Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    private fun ubicacion(): String{
        val carpeta = File(getExternalFilesDir(null),"notas")
        if(!carpeta.exists())
        {
            carpeta.mkdir()
        }
        return carpeta.absolutePath
    }
}