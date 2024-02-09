package com.example.re_wear.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.re_wear.HomeActivity
import com.example.re_wear.R
import com.example.re_wear.databinding.ActivityLoginBinding
import com.example.re_wear.handler.LoginActivityHandler
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: TextView
    private lateinit var btnPassReset : TextView
    private lateinit var mAuth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        editEmail = findViewById(R.id.edt_email)
        editPass = findViewById(R.id.edt_pass)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signup)
        btnPassReset = findViewById(R.id.passreset)

        mAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val email = editEmail.text.toString()
            val pass = editPass.text.toString()

            if (email == "" && pass == "") {
                Toast.makeText(
                    this@LoginActivity, "Please Enter the email and password ", Toast.LENGTH_SHORT
                ).show()

            }
            if (email != "" && pass != "") {
                login(email, pass)
            }

        }

        btnPassReset.setOnClickListener {
            val intent = Intent(this, ResetPassActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, pass: String) {
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this@LoginActivity, "User Does not Exist please Sign Up", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}