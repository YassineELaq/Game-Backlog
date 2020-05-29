package com.example.level5gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.level5gamebacklog.model.Game
import kotlinx.android.synthetic.main.activity_add_game.*
import kotlinx.android.synthetic.main.content_add_game.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


const val EXTRA_GAME = "EXTRA_AGME"

class AddGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Add Game"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            onSaveClick()
        }
    }

    private fun onSaveClick() {

        var gameTitle = etTitle.text.toString()
        var gamePlatfrom = etPlatform.text.toString()
        var gameDay = etDay.text.toString()
        var gameMonth = etMonth.text.toString()
        var gameYear = etYear.text.toString()

        var dateString = gameDay + "-" + gameMonth + "-" + gameYear






        if(gameTitle.isBlank()){
            Toast.makeText(this, R.string.titleNotEmpty, Toast.LENGTH_SHORT).show()

        }
        if(gameDay.isBlank() || gameMonth.isBlank() || gameYear.isBlank()){
            Toast.makeText(this, R.string.dateNotValid, Toast.LENGTH_SHORT).show()
        }


        if (gameDay.isNotBlank()&& gameMonth.isNotBlank() && gameYear.isNotBlank() && gameTitle.isNotBlank() && gamePlatfrom.isNotBlank()){
            if(gameDay.toInt() <= 30 && gameDay.toInt()> 0 && gameMonth.toInt()<= 12 && gameMonth.toInt()>0 && gameYear.toInt()>2019 ) {

                val formatter =
                    SimpleDateFormat("dd-MM-yyy")

                val date: Date = formatter.parse(dateString)

                var game = Game(gameTitle, gamePlatfrom, date)
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK,resultIntent)
                finish()

            }else{
                Toast.makeText(this, R.string.dateNotValid, Toast.LENGTH_SHORT).show()

        }

        }




    }

    }
