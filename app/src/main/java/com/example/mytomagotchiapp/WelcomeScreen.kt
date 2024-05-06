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
// Intent inspired by Kincade as he showed how to access a different screen by pressing a button
        accessBtn.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)

        }
        // Glide implementation link:https://www.geeksforgeeks.org/image-loading-caching-library-android-set-2/
        val imageView = findViewById<ImageView>(R.id.imageView2);
        // Allows gif to be displayed instead of just a still image
        Glide.with(this)
            .load(R.drawable.cat_that_is_sitting)
            .into(imageView)
    }
}