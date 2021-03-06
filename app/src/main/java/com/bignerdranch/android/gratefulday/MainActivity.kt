package com.bignerdranch.android.gratefulday

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chooseButton: Button
    private lateinit var resultImage: ImageView
    private lateinit var rankButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var previousButton: ImageButton
    private var resultNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chooseButton = findViewById(R.id.choose_button)
        resultImage = findViewById(R.id.day_image)
        rankButton = findViewById(R.id.rank_button)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)

        chooseButton.setOnClickListener {
            Toast.makeText(
                this, "cám ơn, cám ơn, cám ơn :D",
                Toast.LENGTH_SHORT
            ).show()

            val randomInt = (1..28).random()
            resultNumber = randomInt
            setImage()
            saveResultNumber()
        }

        rankButton.setOnClickListener {
            Toast.makeText(
                this, "chúc bạn 1 ngày tốt lành :D",
                Toast.LENGTH_SHORT
            ).show()

            if (resultNumber in 0.. 27) {
                resultNumber++
            } else {
                resultNumber = 0
            }
            setImage()
            saveResultNumber()
        }
        previousButton.setOnClickListener {
            if (resultNumber in 1..28) {
                resultNumber--
            } else {
                resultNumber = 0
            }

            setImage()
            saveResultNumber()
        }
        nextButton.setOnClickListener {
            if (resultNumber in 1..27) {
                resultNumber++
            } else {
                resultNumber = 0
            }

            setImage()
            saveResultNumber()
        }
    }

    override fun onStart() {
        super.onStart()
        updateResultNumber()
    }

    private fun saveResultNumber(){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        with(sharedPreferences.edit()){
            putInt("resultNumber", resultNumber)
            apply()
        }
    }

    private fun updateResultNumber(){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        resultNumber = sharedPreferences.getInt("resultNumber", -1)
        setImage()
    }

    private fun setImage() {
        val drawableResource = when (resultNumber) {
            0 -> R.drawable.grateful_0
            1 -> R.drawable.grateful_01
            2 -> R.drawable.grateful_02
            3 -> R.drawable.grateful_03
            4 -> R.drawable.grateful_04
            5 -> R.drawable.grateful_05
            6 -> R.drawable.grateful_06
            7 -> R.drawable.grateful_07
            8 -> R.drawable.grateful_08
            9 -> R.drawable.grateful_09
            10 -> R.drawable.grateful_10
            11 -> R.drawable.grateful_11
            12 -> R.drawable.grateful_12
            13 -> R.drawable.grateful_13
            14 -> R.drawable.grateful_14
            15 -> R.drawable.grateful_15
            16 -> R.drawable.grateful_16
            17 -> R.drawable.grateful_17
            18 -> R.drawable.grateful_18
            19 -> R.drawable.grateful_19
            20 -> R.drawable.grateful_20
            21 -> R.drawable.grateful_21
            22 -> R.drawable.grateful_22
            23 -> R.drawable.grateful_23
            24 -> R.drawable.grateful_24
            25 -> R.drawable.grateful_25
            26 -> R.drawable.grateful_26
            27 -> R.drawable.grateful_27
            28 -> R.drawable.grateful_28
            else ->R.drawable.grateful_0
        }
        resultImage.setImageResource(drawableResource)
    }
}

