package com.mrbattery.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mrbattery.genaral.R

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
