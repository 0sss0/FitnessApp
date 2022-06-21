package com.example.fitnessapp.ui.login.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.login.signin.SignInActivity
import com.example.fitnessapp.ui.login.signup.SignUpActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_welcome)

            findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        findViewById<TextView>(R.id.loginView).setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}