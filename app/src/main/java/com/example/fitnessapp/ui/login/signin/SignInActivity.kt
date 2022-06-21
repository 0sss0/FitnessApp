package com.example.fitnessapp.ui.login.signin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R


class SignInFragment : Fragment(R.layout.fragment_signin) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolBar)
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
        }
    }
}