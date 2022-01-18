package com.jay.wjcalendar

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jay.wjcalendar.databinding.ActivityMainBinding
import com.jay.wjcalendarmodule.model.WJWeekColor

@SuppressLint("ResourceType")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.twoCv.setWeekColor(
            listOf(
                WJWeekColor(
                    week = 0,
                    color = ContextCompat.getColor(this, R.color.purple_200)
                ),
                WJWeekColor(
                    week = 4,
                    color = ContextCompat.getColor(this, R.color.purple_500)
                ),
                WJWeekColor(
                    week = 6,
                    color = ContextCompat.getColor(this, R.color.material_on_surface_stroke)
                )
            )
        )
    }
}