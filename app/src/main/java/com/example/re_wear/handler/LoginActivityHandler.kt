package com.example.re_wear.handler

import android.content.Context
import android.content.Intent
import com.example.re_wear.auth.ResetPassActivity

class LoginActivityHandler(private var mContext: Context) {

    fun onclickReset(){

        mContext.startActivity(Intent(mContext, ResetPassActivity::class.java))

    }
}