package casal.jose.mis_notas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.File

class AdaptadorNotas: BaseAdapter{
    var context:Context
    var notas=ArrayList<Nota>()

    constructor(context:Context, notas:ArrayList<Nota>){
        this.context = context
        this.notas = notas
    }
    override fun getCount(): Int {
        return notas.size
    }

    override fun getItem(p0: Int): Any {
        return notas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.nota_layout, null)
        var nota = notas[p0]

        var titulo = vista.findViewById(R.id.tv_titulo_det) as TextView
        var contenido = vista.findViewById(R.id.tv_contenido_det) as TextView
        val btnBorrar = vista.findViewById(R.id.btn_borrar) as ImageView

//Si truena es porque le falta el "toString()" acuerdate de mi jose del futuro
        titulo.setText(nota.titulo)
        contenido.setText(nota.contenido)

        btnBorrar.setOnClickListener {
            //borrar() poner despues
            notas.remove(nota)
            this.notifyDataSetChanged()
        }
        return vista
    }

    private fun eliminar(titulo: String){
        if(titulo == "")
        {
            Toast.makeText(context,"Error: Título vacío", Toast.LENGTH_SHORT).show()
        }
        else
        {
            try
            {
                val archivo = File(ubicacion(),titulo + ".txt")
                archivo.delete()
                Toast.makeText(context,"Se eliminó el archivo", Toast.LENGTH_SHORT).show()
            }
            catch(e:Exception)
            {
                Toast.makeText(context,"Error al eliminar el archivo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun ubicacion(): String{
        val album= File(context?.getExternalFilesDir(null),"notas")
        if(!album.exists())
        {
            album.mkdir()
        }
        return album.absolutePath
    }
}