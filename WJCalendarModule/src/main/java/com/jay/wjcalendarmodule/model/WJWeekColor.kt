package com.jay.wjcalendarmodule.model

import androidx.annotation.ColorInt

/**
 * [week]
 * 0 = 일요일
 * 1 = 월요일
 * 2 = 화요일
 * 3 = 수요일
 * 4 = 목요일
 * 5 = 금요일
 * 6 = 토요일
 */
data class WJWeekColor(
    val week: Int,
    @ColorInt val color: Int
)