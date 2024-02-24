package com.example.re_wear

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.re_wear.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity(){

    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}