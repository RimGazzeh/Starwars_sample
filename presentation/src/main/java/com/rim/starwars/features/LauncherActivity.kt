package com.rim.starwars.features

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.rim.starwars.R

class LauncherActivity : AppCompatActivity() {
    private val mTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, mTimeOut)
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}