package com.jay.wjcalendarmodule.calendar

import com.jay.wjcalendarmodule.model.WJCalendarEntity

interface WJCalendar {

    fun initCalendar()
    fun setupCalendar(year: Int, month: Int)

    fun createBlankList(): List<WJCalendarEntity>
    fun createDayList(): List<WJCalendarEntity>

    fun firstDayOfWeek(): Int
    fun lastDayOfMonth(): Int

    fun setYear(year: Int)
    fun setMonth(month: Int)
    fun setDay(day: Int)

    fun getYear(): Int
    fun getMonth(): Int
    fun getDay(): Int
    fun getCurrentDate(): String

    fun nextMonth(): List<WJCalendarEntity>
    fun beforeMonth(): List<WJCalendarEntity>

    fun testCaseNextMonth(): Int
    fun testCaseBeforeMonth(): Int

}