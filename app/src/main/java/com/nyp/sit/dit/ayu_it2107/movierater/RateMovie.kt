@file:Suppress("DEPRECATION")

package com.nyp.sit.dit.ayu_it2107.movierater

import android.content.Intent
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class RateMovie : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_movie)

        val intent = intent
        val title = intent.getStringExtra("Title")

        val titleTv = findViewById<TextView>(R.id.tvTitle)
        titleTv.text = "Enter your review for the movie: Venom";


    }
}
