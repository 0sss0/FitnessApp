package com.example.fitnessapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.data.CardsData
import com.example.fitnessapp.domain.entity.CardType
import com.example.fitnessapp.ui.adapter.RecyclerViewAdapter

class UsersTrackFragment : Fragment (R.layout.fragment_users_activity) {
    private val activityData = CardsData()

    private val adapter = RecyclerViewAdapter {
        val information =
            TrackFragmentDirections.actionTrackFragmentToTrackDetailsFragment(
                it.distance,
                it.period,
                it.typeActivity,
                it.dateActivity,
                it.cardType,
                it.nickname
            )

        findNavController().navigate(information)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.usersCards).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@UsersTrackFragment.adapter
        }
        adapter.setData(activityData.getDefaultData(CardType.Users))
    }

}