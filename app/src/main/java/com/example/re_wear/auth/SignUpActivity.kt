package com.example.re_wear.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.re_wear.R
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var enter_eml: EditText
    private lateinit var enter_pas: EditText
    private lateinit var btnsignIn: TextView
    private lateinit var btnLogin: TextView
    private lateinit var mAuth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        enter_eml = findViewById(R.id.enter_email)
        enter_pas = findViewById(R.id.enter_pass)
        btnLogin = findViewById(R.id.alreadyAcc)
        btnsignIn = findViewById(R.id.btnSignUp)
        mAuth = FirebaseAuth.getInstance()


        btnsignIn.setOnClickListener {
            val email = enter_eml.text.toString()
            val pass = enter_pas.text.toString()

            if (email == "" && pass == "") {
                Toast.makeText(
                    this@SignUpActivity, "Please Enter the email and password ", Toast.LENGTH_SHORT
                ).show()

            }
            if (email != "" && pass != "") {
                signUp(email, pass)
            }
        }
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signUp(email: String, pass: String) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@SignUpActivity, "User Already Exist please Login", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}