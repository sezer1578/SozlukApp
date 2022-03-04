package com.example.sozlukuygulamasisqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sozlukuygulamasisqlite.model.Words
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val word = intent.getSerializableExtra("object") as Words
        toolbarDetail.title ="${word.english} Detayı "
        setSupportActionBar(toolbarDetail)
        textViewDetailEnglish.text = word.english
        textViewDetailTurkish.text = word.turkish
    }
}