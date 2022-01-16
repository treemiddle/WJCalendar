package com.jay.wjcalendar

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jay.wjcalendar.databinding.ActivityMainBinding
import com.jay.wjcalendarmodule.WJCalendarView
import com.jay.wjcalendarmodule.calendarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            calendarView(this@MainActivity) {
                setDayBackgroundColor(Color.RED)
            }
        }
    }
}