@file:Suppress("DEPRECATION")

package com.nyp.sit.dit.ayu_it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rbtnLanguageGroup = findViewById<RadioGroup>(R.id.rbtnLanguage);

        chkbxNotSuitable.setOnClickListener {
            if (chkbxNotSuitable.isChecked) {
                chkbxViolence.setVisibility(View.VISIBLE);
                chkbxLangugeUsed.setVisibility(View.VISIBLE);

            } else {
                chkbxViolence.setVisibility(View.GONE);
                chkbxLangugeUsed.setVisibility(View.GONE);
            }
        }

        btnAddMovie.setOnClickListener {
            val txtName: String = etName.text.toString();
            val txtDescription: String = etDescription.text.toString();
            val txtDate: String = etReleaseDate.text.toString();

            val selectLanguageId = rbtnLanguageGroup.getCheckedRadioButtonId();
            val rbtnLanguage = findViewById<RadioButton>(selectLanguageId);

            var txtNotSuitable :String = "";
            var txtReason :String= "";


            if(chkbxNotSuitable.isChecked()) {
                txtNotSuitable += "false"
                if(chkbxLangugeUsed.isChecked() && chkbxViolence.isChecked()) {
                    txtReason+= "\nViolence\nLanguage"
                }else if (chkbxLangugeUsed.isChecked()) {
                    txtReason += "\nLanguage"
                }else if (chkbxViolence.isChecked()){
                    txtReason += "\nViolence"
                }
            } else {
                txtNotSuitable += "true"
            }

            if(txtName.isNotEmpty() && txtDescription.isNotEmpty()&& txtDate.isNotEmpty()){

                Toast.makeText(getApplicationContext(),
                    "Title = " + txtName
                                + "\nOverview = " + txtDescription
                                + "\nRelease date = " + txtDate
                                + "\nLanguage = " + rbtnLanguage.getText()
                                +  "\nSuitable for all ages = " + txtNotSuitable
                                +  "\nReason : " + txtReason , Toast.LENGTH_SHORT).show();
                val intent = Intent(this,ViewMovieDetails::class.java);
                intent.putExtra("Title",txtName)
                intent.putExtra("Description",txtDescription)
                intent.putExtra("Release Date",txtDate)
                intent.putExtra("Language",rbtnLanguage.getText())
                intent.putExtra("Suitable for children below 13",txtNotSuitable)
                startActivity(intent);
            }else{
                if(txtName.isEmpty()) {
                    etName.setError("Field Empty");
                    if (txtDescription.isEmpty()){
                        etDescription.setError("Field Empty");
                        if (txtDate.isEmpty()){
                            etReleaseDate.setError("Field Empty");
                        }
                    }
                }

            }

        }
    }
}





