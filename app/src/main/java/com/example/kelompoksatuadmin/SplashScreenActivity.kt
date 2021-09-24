package com.example.kelompoksatuadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import com.example.kelompoksatuadmin.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar?.hide()

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        binding.splashSreen.alpha = 0f
        binding.splashSreen.animate().setDuration(1500).alpha(1f).withEndAction {
            Handler().postDelayed({
                                  if (user != null) {
                                      startActivity(Intent(this, MainActivity::class.java))
                                      overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                                      finish()
                                  }else {
                                      startActivity(Intent(this, MainActivity::class.java))
                                      overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                                      finish()
                                  }
            },200)
        }
    }
}