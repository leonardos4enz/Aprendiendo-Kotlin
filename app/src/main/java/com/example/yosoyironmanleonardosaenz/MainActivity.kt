package com.example.yosoyironmanleonardosaenz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView
import android.util.Log
import android.widget.Button
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar?.hide()

        tts = TextToSpeech(this,this)

        findViewById<Button>(R.id.btnPlay).setOnClickListener {
            var message: String = findViewById<TextView>(R.id.textView).text.toString()
            Log.i("message textView", message)
            tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.textView).text ="Technoblade never dies"
            tts!!.language = Locale.US
        }else{
            findViewById<TextView>(R.id.textView).text = "No disponible:("
        }
    }
}
