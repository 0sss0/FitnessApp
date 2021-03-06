package com.example.fitnessapp.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R

class SignUpFragment : Fragment(R.layout.fragment_signup) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val span = SpannableString("Нажимая на кнопку, вы соглашаетесь с политикой конфидециальности и обработки персональных данных, а также принимаете пользовательское соглашение")
        val clickSpanOne: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(text: TextPaint) {
                text.color = text.linkColor
                text.isUnderlineText = false
            }
            override fun onClick(view: View) {
                Toast.makeText(requireActivity().application,"Политикой конфиденциальности", Toast.LENGTH_LONG).show()
            }
        }
        val clickSpanTwo: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(text: TextPaint) {
                text.color = text.linkColor
                text.isUnderlineText = false
            }
            override fun onClick(view: View) {
                Toast.makeText(requireActivity().application, "Пользовательское соглашение", Toast.LENGTH_LONG).show()
            }
        }

        span.setSpan(clickSpanOne, 37, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(clickSpanTwo, span.length - 27, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val text = view.findViewById<TextView>(R.id.termsOfUseView)
        text.movementMethod = LinkMovementMethod()
        text.text = span

        val toolbar = view.findViewById<Toolbar>(R.id.toolBar)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_trackFragment)
        }
    }
}