package com.example.kelompoksatuadmin.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kelompoksatuadmin.R
import com.example.kelompoksatuadmin.databinding.ActivityEditGuideBinding

class EditGuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_guide)
    }
}