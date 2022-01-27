package com.sriv.shivam.discordbotsample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.sriv.shivam.discordbotsample.utils.API.api
import org.javacord.api.interaction.SlashCommand

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getChannels()

        val button: Button = findViewById(R.id.buttonSend)
        val messageEditText: EditText = findViewById(R.id.editTextMessage)

        button.setOnClickListener {
            val message = messageEditText.text.toString()
            sendMessage(message)
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun sendMessage(message: String) {
        val channel = api.getTextChannelById("932942482327617579")
        channel.ifPresent { textChannel ->
            textChannel.sendMessage(message)
        }
    }

    private fun getChannels() {
        println(api.channels)
        for(cha in api.channels) {
            Log.d("event", cha.toString())
        }

//        SlashCommandClass.createSlashCommand(api)
    }

    override fun onStop() {
        super.onStop()
        api.disconnect()
    }
}