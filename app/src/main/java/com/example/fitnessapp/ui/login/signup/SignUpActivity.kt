package com.example.fitnessapp.ui.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import androidx.activity.viewModels
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.fitnessapp.R
import com.example.fitnessapp.retrofit.AuthHolder
import com.example.fitnessapp.CustomViewModelFactory
import com.example.fitnessapp.ui.login.main.MainActivity
import com.example.fitnessapp.ui.login.main.WelcomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private val viewModel by viewModels<SignUpViewModel> {
        CustomViewModelFactory { SignUpViewModel(AuthHolder(applicationContext)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_signup)

        val span =
            SpannableString("Нажимая на кнопку, вы соглашаетесь с политикой конфиденциальности и обработки персональных данных, а также принимаете пользовательское соглашение")
        val clickSpanOne: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(text: TextPaint) {
                text.color = text.linkColor
                text.isUnderlineText = false
            }

            override fun onClick(view: View) {
                Toast.makeText(
                    applicationContext,
                    "Политика конфиденциальности",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        val clickSpanTwo: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(text: TextPaint) {
                text.color = text.linkColor
                text.isUnderlineText = false
            }

            override fun onClick(view: View) {
                Toast.makeText(
                    applicationContext,
                    "Пользовательское соглашение",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        span.setSpan(clickSpanOne, 37, 66, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(clickSpanTwo, span.length - 27, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val text = findViewById<TextView>(R.id.termsOfUseView)
        text.movementMethod = LinkMovementMethod()
        text.text = span

        findViewById<Toolbar>(R.id.toolBar).setNavigationOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }


        viewModel.showLoginError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.loginInput).error = "Введите логин"
            } else {
                findViewById<TextInputLayout>(R.id.loginInput).error = null
            }
        }
        viewModel.showNameError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.nickInput).error = "Введите имя или никнейм"
            } else {
                findViewById<TextInputLayout>(R.id.nickInput).error = null
            }
        }
        viewModel.showPasswordError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.passwordInput).error = "Введите пароль"
            } else {
                findViewById<TextInputLayout>(R.id.passwordInput).error = null
            }
        }
        viewModel.showRepeatPasswordError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.repeatPasswordInput).error = "Повторите пароль"
            } else {
                findViewById<TextInputLayout>(R.id.repeatPasswordInput).error = null
            }
        }
        viewModel.showWrongRepeatPasswordError.observe(this) {
            if (it) {
                findViewById<TextInputLayout>(R.id.repeatPasswordInput).error =
                    "Неверно введен пароль"
            } else {
                findViewById<TextInputLayout>(R.id.repeatPasswordInput).error = null
            }
        }

        var gender = 0
        findViewById<RadioGroup>(R.id.sexRadioGroup).setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.sexRadioMan) {
                gender = 0
            } else if (checkedId == R.id.sexRadioWoman) {
                gender = 1
            } else {
                gender = 2
            }
        }

        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            viewModel.onRegistrationClicked(
                findViewById<TextInputEditText>(R.id.login).text.toString(),
                findViewById<TextInputEditText>(R.id.password).text.toString(),
                findViewById<TextInputEditText>(R.id.passwordRepeat).text.toString(),
                findViewById<TextInputEditText>(R.id.name).text.toString(),
                gender
            )
        }

        viewModel.result.observe(this) {
            if (it == "Успех") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else if (it != "") {
                Toast.makeText(
                    this,
                    it,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}