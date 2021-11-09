package casal.jose.mis_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import java.io.*

class MainActivity : AppCompatActivity() {
    private var notas = ArrayList<Nota>()
    private lateinit var adaptador:AdaptadorNotas
    private var lista: ListView = findViewById(R.id.listView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: Button = findViewById(R.id.fab) as Button
        fab.setOnClickListener {
            var intent = Intent(this, AgregaNotaActivity::class.java)
            startActivityForResult(intent, 123)
        }
        leerNotas()

        adaptador = AdaptadorNotas(this,notas)
        lista.adapter=adaptador
    }

    fun leerNotas(){
        notas.clear()
        var carpeta = File(ubicacion().absolutePath)

        if(carpeta.exists())
        {
            var archivos = carpeta.listFiles()
            if(archivos != null)
            {
                var contador: Int = 0
                for(archivo in archivos)
                {
                    leerArchivo(archivo)
                }
            }
        }
    }

    fun leerArchivo(archivo:File){
        val fis = FileInputStream(archivo)
        val di = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(di))
        var strLine: String? = br.readLine()
        var myData = ""

        while(strLine != null)
        {
            myData = myData + strLine
            strLine = br.readLine()
        }

        br.close()
        di.close()
        fis.close()

        var nombre = archivo.name.substring(0,archivo.name.length-4)
        var nota = Nota(nombre,myData)
        notas.add(nota)
    }

    private fun ubicacion():File{
        val folder = File(getExternalFilesDir(null),"notas")
        if(!folder.exists())
        {
            folder.mkdir()
        }
        return folder
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123)
        {
            leerNotas()
            adaptador.notifyDataSetChanged()
        }
    }
}