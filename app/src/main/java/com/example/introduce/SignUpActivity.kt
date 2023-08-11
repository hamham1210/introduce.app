package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            if (editname.text.isNotBlank() && editpw.text.isNotBlank() && editid.text.isNotBlank()){
                    btnsignup.setOnClickListener {
                        Toast.makeText(
                            this,
                            getString(R.string.toast_msg_signupS),
                            Toast.LENGTH_SHORT
                        ).show()
                        var intent = Intent(this, SignInActivity::class.java)
                        intent.putExtra("id", editid.text.toString())
                        intent.putExtra("pw", editpw.text.toString())
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                }
                else {
                    btnsignup.setOnClickListener {
                        Toast.makeText(
                            this,
                            getString(R.string.toast_signup_Err),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        signup()
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
