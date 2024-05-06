package com.example.mytomagotchiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mytomagotchiapp.R.id.petView

class MainActivity : AppCompatActivity() {

    private lateinit var petView: ImageView
    private lateinit var resultView: TextView
    // Allows display of status of pet to change based on user input
    private var happiness : Int = 6
    private var hunger : Int = 0
    private var clean : Int = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultTxtView)
        petView = findViewById(R.id.petView);
        Glide.with(this)
            .load(R.drawable.cat_that_is_sitting)
            .into(petView)
        val playBtn = findViewById<Button>(R.id.happyBtn)
        val feedBtn = findViewById<Button>(R.id.hungerBtn)
        val cleanBtn = findViewById<Button>(R.id.cleanBtn)

        playBtn.setOnClickListener {
            play()
           Glide.with(this)
               .load(R.drawable.cat_really_playing)
               .into(petView)
        }
        feedBtn.setOnClickListener {
            feed()
            Glide.with(this)
                .load(R.drawable.cat_eating)
                .into(petView)
        }
        cleanBtn.setOnClickListener {
            clean()
            Glide.with(this)
                .load(R.drawable.clean_cat)
                .into(petView)

        }
    }
    // Edits displayed text when playBtn is pressed by user
    private fun play() {
        if (happiness < 10) happiness +=4
        if (happiness > 10) happiness = 10
        if (hunger < 10) hunger +=3
        if (hunger > 10) hunger = 10
        if (clean > 0)clean -=4
        if (clean < 0)clean = 0
        updateTextView()
    }
    // Edits displayed text when feedBtn is pressed by user
    private fun feed() {
        if (hunger > 0)hunger -= 5
        if (hunger < 0)hunger = 0
        if (clean < 10)clean +=2
        if (clean > 10)clean = 10
        if (happiness > 0)happiness -=2
        if (happiness < 0)happiness = 0
        updateTextView()
    }
    // Edits displayed text when cleanBtn is pressed by user
    private fun clean() {
        if (happiness > 0) happiness = 0
        if (clean < 10) clean +=6
        if (clean > 10) clean = 10
        if (hunger < 10) hunger +=2
        if (hunger > 10) hunger = 10

        updateTextView()
    }
    // inspired by Kincade as he showed how to change displayed text when a user presses a button
    // updates TextView when any of the three buttons is pressed
    private fun updateTextView() {
        resultView.text ="Health= $clean Hunger= $hunger Happiness= $happiness"

    }
}