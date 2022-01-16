package com.jay.wjcalendarmodule.mapper

import androidx.annotation.ColorInt
import com.jay.wjcalendarmodule.calendar.WJCalendarType
import com.jay.wjcalendarmodule.model.WJCalendarEntity

fun List<WJCalendarEntity>.toDayColor(@ColorInt color: Int): List<WJCalendarEntity> {
    this.forEach {
        if (it.type == WJCalendarType.DAY) {
            it.textColor = color
        }
    }

    return this
}