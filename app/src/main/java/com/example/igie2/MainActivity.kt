package com.example.igie2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var startButton: Button
    private lateinit var timerLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        startButton = findViewById(R.id.start_button)
        timerLabel = findViewById(R.id.timer_label)

        startButton.setOnClickListener {
            val selectedValue = spinner.selectedItem.toString()
            val seconds = selectedValue.split(" ")[0].toInt()
            startTimer(seconds)
        }
    }

    private fun startTimer(seconds: Int) {
        var count = seconds
        while (count >= 0) {
            timerLabel.text = count.toString()
            if (count == 0) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.warning_sound)
                mediaPlayer.start()
            }
            count--
            print(count)
            Thread.sleep(1000)
        }
    }
}