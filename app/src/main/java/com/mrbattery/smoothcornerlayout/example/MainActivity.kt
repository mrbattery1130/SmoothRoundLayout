package com.mrbattery.smoothcornerlayout.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val rl = findViewById<GeneralRoundRelativeLayout>(R.id.rl)
//        rl.setOnClickListener {
//            rl.setCornerRadius(140f)
//            rl.invalidate()
//        }
    }
}
