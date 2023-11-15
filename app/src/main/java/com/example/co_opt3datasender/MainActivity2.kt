package com.example.co_opt3datasender

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setTitle("Act 2")

        val intent = intent
        val name = intent.getStringExtra("name")
        val number1 = intent.getIntExtra("number1", 0)
        val number2 = intent.getIntExtra("number2", 0)

        val textViewName: TextView = findViewById(R.id.text_view_name)
        textViewName.text = "Name: $name"

        val textViewNumbers: TextView = findViewById(R.id.text_view_numbers)
        textViewNumbers.text = "Numbers: $number1, $number2"

        val buttonAdd: Button = findViewById(R.id.button_add)
        val buttonSub: Button = findViewById(R.id.button_subtract)

        buttonAdd.setOnClickListener {
            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        buttonSub.setOnClickListener {
            val result = number1 - number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}