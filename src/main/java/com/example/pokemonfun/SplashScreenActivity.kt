@file:Suppress("DEPRECATION")

package com.example.pokemonfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash_screen)
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        handler = Handler()
        handler.postDelayed({
            startActivity(intent)
            finish()
        },3000)

    }
}