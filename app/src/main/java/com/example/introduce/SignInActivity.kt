package com.example.introduce

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val idEditText = findViewById<EditText>(R.id.input_id)//아이디 입력 뷰를 불러온다.
        val pwEditText = findViewById<EditText>(R.id.input_password)//비밀번호 입력 뷰를 불러온다.
        val btnlogin = findViewById<Button>(R.id.button_login)//로그인 버튼 뷰를 불러온다.
        val btnsignup = findViewById<Button>(R.id.button_signin)//회원 가입 버튼을 불러온다.
        fun checkAndShowToast() {
            when {
                idEditText.text.isNotBlank() && pwEditText.text.isNotBlank() -> {
                    btnlogin.setOnClickListener {
                        val intent = Intent(this, HomeActivity::class.java)
                        val id = idEditText.text.toString()
                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                        intent.putExtra("ID", id) // ID라는 name으로 id value를 담아서 전달한다.
                        startActivity(intent)
                    }//토스트 메시지 생성
                }

                else -> {
                    btnlogin.setOnClickListener {
                        Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                    }
                    return
                }
            }
        }
        btnsignup.setOnClickListener {
            var intentsignup = Intent(this, SignUpActivity::class.java)
            startActivity(intentsignup)
        }

        idEditText.addTextChangedListener {
            checkAndShowToast()
        }
        pwEditText.addTextChangedListener {
            checkAndShowToast()
        }
    }
}



