package com.example.homework_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class EditContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

    }

    fun clickToCancel(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun clickToSave(view: View) {
        // ---- to know which button called the page
        var whichButton : String = intent.getStringExtra("button").toString()
        Log.d("Button: ", whichButton)

        val editName: TextView = findViewById(R.id.edit_name)
        val messageName = editName.text.toString()

        val editPhone: TextView = findViewById(R.id.edit_phone_number)
        val messagePhone = editPhone.text.toString()
        Log.d("Name: ", messageName)
        Log.d("Phone: ", messagePhone)

        val intent = Intent(this, MainActivity::class.java)
        if (whichButton == "1") {
            intent.putExtra("new_name_1", messageName)
            intent.putExtra("new_phone_1", messagePhone)
        }
        if (whichButton == "2") {
            intent.putExtra("new_name_2", messageName)
            intent.putExtra("new_phone_2", messagePhone)
        }
        if (whichButton == "3") {
            intent.putExtra("new_name_3", messageName)
            intent.putExtra("new_phone_3", messagePhone)
        }
        startActivity(intent)
    }
}