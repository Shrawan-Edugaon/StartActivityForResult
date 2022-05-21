package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MessageActivity : AppCompatActivity() {

    lateinit var message_edt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        message_edt = findViewById(R.id.message_edt)
    }
    fun submitMessage(v: View)
    {
        val messageEdt = message_edt.text.toString()
        val returnBackIntent = Intent()
        returnBackIntent.putExtra("result",messageEdt)
            setResult(Activity.RESULT_OK,returnBackIntent)

        finish()
    }
}
