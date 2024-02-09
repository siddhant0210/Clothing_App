package com.example.re_wear.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.re_wear.R
import com.example.re_wear.handler.ResetPassActivityHandler
import com.example.re_wear.databinding.ActivityPassresetBinding


class ResetPassActivity : AppCompatActivity() {
    private lateinit var resetPassBinding: ActivityPassresetBinding

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resetPassBinding = DataBindingUtil.setContentView(this, R.layout.activity_passreset)

        resetPassBinding.handler = ResetPassActivityHandler(this, resetPassBinding)
    }
}