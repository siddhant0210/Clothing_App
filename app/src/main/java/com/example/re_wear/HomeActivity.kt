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
import dagger.hilt.android.AndroidEntryPoint

class HomeActivity : AppCompatActivity() {
    private lateinit var btnlogout: Button

    private lateinit var bottomNavigation: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)




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



}
