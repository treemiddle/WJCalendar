package com.jay.wjcalendarmodule.model

import com.jay.wjcalendarmodule.calendar.WJCalendarType

data class WJCalendarEntity(
    val type: WJCalendarType? = null,
    val value: Int = 0
)