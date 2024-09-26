package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.snapp.khabar.R

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        val backButton = view.findViewById<ImageButton>(R.id.btnBack)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        val switch1 = view.findViewById<Switch>(R.id.switch1)
        switch1.setOnCheckedChangeListener { compoundButton, isEnabled ->
            Log.d("TAG", "onCreateView: isOn: $isEnabled")
            if (isEnabled) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            }
        }


        return view
    }

}