package com.example.homework_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ---- init ----
        var phone_1Text : TextView = findViewById(R.id.phone_1)
        var phone_2Text : TextView = findViewById(R.id.phone_2)
        var phone_3Text : TextView = findViewById(R.id.phone_3)

        phone_1Text.text = intent.getStringExtra("new_phone_1").toString()
        phone_2Text.text = intent.getStringExtra("new_phone_2").toString()
        phone_3Text.text = intent.getStringExtra("new_phone_3").toString()

        var button_1 : Button = findViewById(R.id.value_1)
        var button_2 : Button = findViewById(R.id.value_2)
        var button_3 : Button = findViewById(R.id.value_3)

        if (intent.getStringExtra("new_name_1").toString() == "null") {
            button_1.text = ""
        } else {
            button_1.text = intent.getStringExtra("new_name_1").toString()
        }
        if (intent.getStringExtra("new_name_2").toString() == "null") {
            button_2.text = ""
        } else {
            button_2.text = intent.getStringExtra("new_name_2").toString()
        }
        if (intent.getStringExtra("new_name_3").toString() == "null") {
            button_3.text = ""
        } else {
            button_3.text = intent.getStringExtra("new_name_3").toString()
        }

        // ---- long click -----

        var button_cancel : ImageButton = findViewById(R.id.cancel_button)

        button_cancel.setOnLongClickListener {
            val editText : TextView = findViewById(R.id.board_text)
            editText.text = ""
            false
        }

        button_1.setOnLongClickListener {
            val intent = Intent(this, EditContact::class.java)
            intent.putExtra("button", "1")
            startActivity(intent)
            false
        }

        button_2.setOnLongClickListener {
            val intent = Intent(this, EditContact::class.java)
            intent.putExtra("button", "2")
            startActivity(intent)
            false
        }

        button_3.setOnLongClickListener {
            val intent = Intent(this, EditContact::class.java)
            intent.putExtra("button", "3")
            startActivity(intent)
            false
        }
    }

    fun clickToCall(view: View) {
        val editText : TextView = findViewById(R.id.board_text)
        val message = editText.text.toString()
        var finalText = "tel:".plus(message)
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(finalText)
        startActivity(intent)
    }

    fun clickToDelete(view: View) {
        val editText : TextView = findViewById(R.id.board_text)
        val message = editText.text.toString()
        val newText : String
        if (message.length > 0) {
            newText = message.substring(0, message.length -1)
        } else {
            newText = ""
        }
        editText.text = newText
    }

    fun clickNumber(view: View) {
        val editText : TextView = findViewById(R.id.board_text)
        val message = editText.text.toString()

        //---- get value from board_text ----
        val newText : String
        val id : String = view.getId().toString()
        Log.d("ID:::", id)

        //---- get values for 3 buttons ----
        var phone_1Text : TextView = findViewById(R.id.phone_1)
        var phone_1 : String = phone_1Text.text.toString()
        var phone_2Text : TextView = findViewById(R.id.phone_2)
        var phone_2 : String = phone_2Text.text.toString()
        var phone_3Text : TextView = findViewById(R.id.phone_3)
        var phone_3 : String = phone_3Text.text.toString()

        when (id) {
            "2131230876" -> newText = message.plus("0")
            "2131230877" -> newText = message.plus("1")
            "2131230878" -> newText = message.plus("2")
            "2131230879" -> newText = message.plus("3")
            "2131230880" -> newText = message.plus("4")
            "2131230881" -> newText = message.plus("5")
            "2131230882" -> newText = message.plus("6")
            "2131230883" -> newText = message.plus("7")
            "2131230884" -> newText = message.plus("8")
            "2131230885" -> newText = message.plus("9")
            "2131230886" -> newText = message.plus("#")
            "2131230887" -> newText = message.plus("+")
            "2131230996" -> newText = phone_1
            "2131230997" -> newText = phone_2
            "2131230998" -> newText = phone_3
            else -> {
                newText = message
            }
        }
        editText.text = newText

    }

}