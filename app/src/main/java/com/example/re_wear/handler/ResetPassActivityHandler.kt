package com.example.re_wear.handler

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.re_wear.auth.LoginActivity
import com.example.re_wear.auth.ResetPassActivity
import com.example.re_wear.databinding.ActivityPassresetBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class ResetPassActivityHandler (private var mContext: Context,
    private var  passResetBinding: ActivityPassresetBinding)
{

    fun onSendLink(){
        val emailAddress = passResetBinding.emailId.text.toString()

        Firebase.auth.sendPasswordResetEmail(emailAddress)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                   Toast.makeText(mContext, " Please Check your Email for the link" ,Toast.LENGTH_SHORT).show()
                    mContext.startActivity(Intent(mContext, LoginActivity::class.java))
                }
            }
    }

}