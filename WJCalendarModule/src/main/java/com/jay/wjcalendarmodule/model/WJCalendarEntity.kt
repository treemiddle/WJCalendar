package com.jay.wjcalendarmodule.model

import android.graphics.Color
import com.jay.wjcalendarmodule.calendar.WJCalendarType

data class WJCalendarEntity(
    val type: WJCalendarType? = null,
    val value: Int = 0,
    var textColor: Int = Color.BLACK
)