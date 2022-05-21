package com.example.startactivityforresult

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_FOR_MESSAGE = 100

    lateinit var defaultMessage : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        defaultMessage = findViewById(R.id.defaultMessage)

        val button = findViewById<Button>(R.id.getmessage)
        button.setOnClickListener {
                val intent = Intent(this, MessageActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_FOR_MESSAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_FOR_MESSAGE && resultCode == Activity.RESULT_OK)
        {
            val message = data!!.getStringExtra("result")
            //By using Kotlinx features we can directly any views IDs from its XML.

            defaultMessage.text = message
        }
    }
}