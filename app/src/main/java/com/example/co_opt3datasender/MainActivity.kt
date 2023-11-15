package com.example.co_opt3datasender

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mTextViewResult: TextView
    private lateinit var mEditTextName: EditText
    private lateinit var mEditTextNumber1: EditText
    private lateinit var mEditTextNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextViewResult = findViewById(R.id.text_view_result)
        mEditTextName = findViewById(R.id.edit_text_name)
        mEditTextNumber1 = findViewById(R.id.edit_text_number1)
        mEditTextNumber2 = findViewById(R.id.edit_text_number2)

        val buttonOpenActivity2: Button = findViewById(R.id.button_open_activity2)
        buttonOpenActivity2.setOnClickListener {
            if (mEditTextNumber1.text.toString().isEmpty() || mEditTextNumber2.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Please input a number", Toast.LENGTH_SHORT).show()
            } else {
                val name = mEditTextName.text.toString()
                val number1 = mEditTextNumber1.text.toString().toInt()
                val number2 = mEditTextNumber2.text.toString().toInt()

                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("name", name)
                intent.putExtra("number1", number1)
                intent.putExtra("number2", number2)
                startActivityForResult(intent, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val result = data?.getIntExtra("result", 0)
                    mTextViewResult.text = result.toString()
                }
                Activity.RESULT_CANCELED -> {
                    mTextViewResult.text = "Nothing selected"
                }
            }
        }
    }
}