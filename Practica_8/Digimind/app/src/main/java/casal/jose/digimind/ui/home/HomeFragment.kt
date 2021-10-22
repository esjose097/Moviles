package casal.jose.digimind.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import casal.jose.digimind.R
import casal.jose.digimind.Task
import casal.jose.digimind.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
//Variables globales que serán utilizaras mas adelante.
    var tasks = ArrayList<Task>()
    private var adaptador:AdaptadorTareas?=null

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fillTask()

        this.adaptador = AdaptadorTareas(root.context, this.tasks)

        val gridView: GridView = root.findViewById(R.id.gridView)
        gridView.adapter=this.adaptador

/*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
 */
        return root
    }

    fun fillTask(){
        tasks.add(Task("Practique 1", arrayListOf("Tuesday"),"17:30"))
        tasks.add(Task("Practique 2", arrayListOf("Monday","Sunday"),"17:40"))
        tasks.add(Task("Practique 3", arrayListOf("Wednesday"),"14:00"))
        tasks.add(Task("Practique 4", arrayListOf("Saturday"),"11:00"))
        tasks.add(Task("Practique 5", arrayListOf("Friday"),"13:00"))
        tasks.add(Task("Practique 6", arrayListOf("Thursday"),"10:40"))
        tasks.add(Task("Practique 7", arrayListOf("Monday"),"12:00"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private class AdaptadorTareas(): BaseAdapter(){
    var tasks = ArrayList<Task>()
    var contexto: Context ?= null

    constructor(contexto:Context, lista:ArrayList<Task>):this(){
        this.contexto = contexto
        this.tasks = lista
    }

    override fun getCount(): Int {
        return this.tasks.size
    }

    override fun getItem(p0: Int): Any {
        return this.tasks[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var task = this.tasks[p0]
        var inflador = LayoutInflater.from(this.contexto)
        var vista = inflador.inflate(R.layout.task_view, null)

        var title: TextView = vista.findViewById(R.id.tv_title) as TextView
        var tv_time:TextView = vista.findViewById(R.id.tv_time) as TextView
        var tv_day:TextView = vista.findViewById(R.id.tv_days) as TextView

        title.setText(task.title)
        tv_time.setText(task.time)
        tv_day.setText(task.days.toString())

        return vista
    }

}