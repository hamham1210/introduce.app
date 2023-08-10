package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        var idEditText = findViewById<EditText>(R.id.input_id)//아이디 입력 뷰를 불러온다.
        var pwEditText = findViewById<EditText>(R.id.input_password)//비밀번호 입력 뷰를 불러온다.
        val btnlogin = findViewById<Button>(R.id.button_login)//로그인 버튼 뷰를 불러온다.
        val btnsignup = findViewById<Button>(R.id.button_signup)//회원 가입 버튼을 불러온다.




        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val id = result.data?.getStringExtra("id") ?: ""
                val pw = result.data?.getStringExtra("pw") ?: ""
                idEditText.setText(id)
                pwEditText.setText(pw)
            }
        }
        btnsignup.setOnClickListener{
        val intent = Intent(this, SignUpActivity::class.java)
        resultLauncher.launch(intent)}



        fun checkAndShowToast() {
            if (idEditText.text.isNotBlank() && pwEditText.text.isNotBlank()) {
                btnlogin.setOnClickListener {
                    val intent = Intent(this, HomeActivity::class.java)
                    val id = idEditText.text.toString()
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    intent.putExtra("ID", id)
                    startActivity(intent)// ID라는 name으로 id value를 담아서 전달한다.
                }//토스트 메시지 생성
            } else {
                btnlogin.setOnClickListener {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
        checkAndShowToast()
        idEditText.addTextChangedListener{
            checkAndShowToast()
        }
        pwEditText.addTextChangedListener {
            checkAndShowToast()
        }

    }
}


