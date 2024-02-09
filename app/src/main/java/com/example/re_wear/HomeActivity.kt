package com.example.re_wear

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.re_wear.auth.MainActivity
import com.example.re_wear.fragments.AccountFragment
import com.example.re_wear.fragments.CartFragment
import com.example.re_wear.fragments.HomeFragment
import com.example.re_wear.fragments.SearchFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {
    private lateinit var btnlogout: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mGoogleSignInClient: GoogleSignInClient

    private lateinit var bottomNavigation: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        mAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1013562950768-l9em58megk8jd3i410vusdd5ammmrht7.apps.googleusercontent.com")
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        btnlogout = findViewById(R.id.Logout_btn)

        btnlogout.setOnClickListener(View.OnClickListener {
            mAuth.signOut()
            //After logging out send user to Login Activity to login again
            moveToSignInActivity()
        })

        bottomNavigation = findViewById(R.id.bottom_nav)

        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_btn -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.search_btn -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.cart_btn -> {
                    replaceFragment(CartFragment())
                    true
                }

                R.id.account_btn -> {
                    replaceFragment(AccountFragment())
                    true
                }

                else -> {
                    false
                }
            }

        }
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }


    private fun moveToSignInActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
