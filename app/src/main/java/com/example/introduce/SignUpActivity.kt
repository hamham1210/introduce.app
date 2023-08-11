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
                        ).show()// 위의 칸들이 비워지 있지 않으면 토스트 메시지를 띄운다.
                        var intent = Intent(this, SignInActivity::class.java)
                        intent.putExtra("id", editid.text.toString())
                        intent.putExtra("pw", editpw.text.toString())
                        setResult(RESULT_OK, intent)//editid와 editpw의 값을 intent에 넣어서 SignIn페이지로 넘긴다.
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
        signup()// 아무것도 입력하지 않았을 때도 메시지를 띄우게한다.
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
