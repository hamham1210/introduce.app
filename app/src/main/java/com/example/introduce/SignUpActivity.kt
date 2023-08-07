package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var editname = findViewById<EditText>(R.id.editText_name)
        var editpw = findViewById<EditText>(R.id.editText_pw)
        var editid = findViewById<EditText>(R.id.editText_id)
        var btnsignup = findViewById<Button>(R.id.buttonsignup)

        fun signup() {
            when {
                editname.text.isNotBlank() && editpw.text.isNotBlank() && editid.text.isNotBlank() -> {
                    btnsignup.setOnClickListener {
                        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                else -> {
                    btnsignup.setOnClickListener {
                        Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }

    }
        editid.addTextChangedListener {
            signup()
        }
        editpw.addTextChangedListener {
            signup()
        }
        editname.addTextChangedListener {
            signup()
        }


    }


}
