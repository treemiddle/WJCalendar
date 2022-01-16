package com.jay.wjcalendar

import android.content.Context
import androidx.core.content.ContextCompat
import com.jay.wjcalendarmodule.WJCalendarView
import com.jay.wjcalendarmodule.calendarView

object WJCalendarFactory {

    fun getWJCalendarView(context: Context): WJCalendarView {
        return calendarView(context) {
            dayBackgroundColor = ContextCompat.getColor(context, R.color.teal_700)
        }
    }
}