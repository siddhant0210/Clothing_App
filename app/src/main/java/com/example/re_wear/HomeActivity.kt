package com.example.re_wear

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.re_wear.auth.MainActivity
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {
    private lateinit var btnlogout: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mAuth = FirebaseAuth.getInstance()

        btnlogout = findViewById(R.id.Logout_btn)

        btnlogout.setOnClickListener(View.OnClickListener {
            FirebaseAuth.getInstance().signOut()
            //After logging out send user to Login Activity to login again
            moveToSignInActivity()
        })
    }

    private fun moveToSignInActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
