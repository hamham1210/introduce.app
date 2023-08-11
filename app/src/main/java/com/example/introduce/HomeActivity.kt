package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    lateinit var imageArray: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {//앱이 최초 실행 됐을때 수행
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) //xml 화면 뷰와 연결한다.
        val input_id = findViewById<TextView>(R.id.input_id)
        val randomImageView = findViewById<ImageView>(R.id.imageprofile)

        imageArray = resources.obtainTypedArray(R.array.self_image).use { typedArray ->
            Array(typedArray.length()) { typedArray.getResourceId(it, 0) }
        } //리소스에 있는 self_image파일의 array를 가져와서 쓴다.
        val randomImageResource = imageArray[Random.nextInt(0, imageArray.size)]
        randomImageView.setImageResource(randomImageResource)
        //imageArray에 있는 그림들을 랜덤으로 띄운다.
        if (intent.hasExtra("ID"))// 만약 intent객체 안에 ID 객체가 있다면 중괄호 안을 실행하라
        {
            input_id.text = intent.getStringExtra("ID")
        }
        val btn_end = findViewById<Button>(R.id.button_finish)
        btn_end.setOnClickListener {
            var intent2 = Intent(this, SignInActivity::class.java)
            startActivity(intent2)
        }
        //end 버튼 누르면 signin페이지로 넘어간다.


    }
}