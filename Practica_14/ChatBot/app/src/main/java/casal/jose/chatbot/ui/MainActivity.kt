package casal.jose.chatbot.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import casal.jose.chatbot.R
import casal.jose.chatbot.data.Message
import casal.jose.chatbot.utils.BotResponse
import casal.jose.chatbot.utils.Constans
import casal.jose.chatbot.utils.Constans.OPEN_GOOGLE
import casal.jose.chatbot.utils.Constans.OPEN_SEARCH
import casal.jose.chatbot.utils.Time
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessangingAdapter
    private val botList = listOf("peter","Francesca","Luigui","Igor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()
        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hello! Today you're speaking with ${botList[random]}, howw can i help you today?")

    }

    private fun clickEvents(){
        val send = findViewById<Button>(R.id.btn_send)
        val message = findViewById<EditText>(R.id.et_message)
        val rv_message = findViewById<RecyclerView>(R.id.rv_message)
        send.setOnClickListener {
            sendMessage()
        }

        message.setOnClickListener {
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main){
                    rv_message.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
    }

    private fun recyclerView(){
        adapter = MessangingAdapter()
        val rv_messages = findViewById<RecyclerView>(R.id.rv_message)
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onStart() {
        super.onStart()
        val rv_messages = findViewById<RecyclerView>(R.id.rv_message)

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage(){
        val messages = findViewById<EditText>(R.id.et_message)
        val rv_message = findViewById<RecyclerView>(R.id.rv_message)

        val message = messages.text.toString()
        val timeStamp = Time.timeStamp()

        if(message.isNotEmpty())
        {
            messages.setText("")
            adapter.insertMessage(casal.jose.chatbot.data.Message(message,
            Constans.SEND_ID, timeStamp))
            rv_message.scrollToPosition((adapter.itemCount - 1))
            botResponse(message)
        }
    }

    private fun botResponse(message:String){
        val timeStamp = Time.timeStamp()
        val rv_message = findViewById<RecyclerView>(R.id.rv_message)

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val response = BotResponse.basicResponses(message)
                adapter.insertMessage(casal.jose.chatbot.data.Message(response, Constans.RECEIVE_ID, timeStamp))

                when(response){
                    OPEN_GOOGLE ->{
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH ->{
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }
                }
            }
        }
    }

    private fun customBotMessage(message:String){
        val rv_message = findViewById<RecyclerView>(R.id.rv_message)
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val timeStamp = Time.timeStamp()
                adapter.insertMessage(casal.jose.chatbot.data.Message(message,Constans.RECEIVE_ID, timeStamp))

                rv_message.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}