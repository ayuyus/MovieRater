@file:Suppress("DEPRECATION")

package com.nyp.sit.dit.ayu_it2107.movierater

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_movie_details.*
import java.awt.font.TextAttribute

@Suppress("DEPRECATION")
class ViewMovieDetails : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)
        btnRate.setOnClickListener{
            val intent = Intent(this,RateMovie::class.java);
            startActivity(intent);
        }

        var intent = intent;
        val title = intent.getStringExtra("Title")
        val desc = intent.getStringExtra("Description")
        val releaseDate = intent.getStringExtra("Release Date")
        val language = intent.getStringExtra("Language")
        val notSuitable = intent.getStringExtra("Suitable for children below 13")

        val detailTv = findViewById<TextView>(R.id.tvDetail);
        detailTv.text = "Title:\n"+ title +
                "\nOverview:\n"+desc+
                "\nLanguage:\n"+language+
                "\nRelease date:\n"+releaseDate+
                "\nSuitable for children below 13:\n"+notSuitable;




    }

}
