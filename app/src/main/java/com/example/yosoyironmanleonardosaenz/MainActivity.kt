package com.example.yosoyironmanleonardosaenz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar?.hide()

        tts = TextToSpeech(this,this)

        findViewById<Button>(R.id.btnPlay).setOnClickListener{speak()}


    }

    private fun speak(){

        var message: String = findViewById<TextView>(R.id.etMessage).text.toString()
        if(message.isEmpty()){
            findViewById<TextView>(R.id.tvStatus).text =getString(R.string.tts_isEmpty)
            message = "Escribe algo por favor"
        }


        //Log.i("message textView", message)
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvStatus).text =getString(R.string.tts_active)
            tts!!.language = Locale("ES")
        }else{
            findViewById<TextView>(R.id.tvStatus).text = getString(R.string.tts_disabled)
        }
    }
    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}
