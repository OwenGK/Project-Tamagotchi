package com.example.mytomagotchiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val accessBtn = findViewById<Button>(R.id.accessBtn)

        accessBtn.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)

        }
        val imageView = findViewById<ImageView>(R.id.imageView2);
        Glide.with(this)
            .load(R.drawable.cat_that_is_sitting)
            .into(imageView)
    }
}