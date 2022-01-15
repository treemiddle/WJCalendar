package com.jay.wjcalendarmodule.calendar

import com.jay.wjcalendarmodule.model.WJCalendarEntity
import java.util.*


class WJCalendarImpl : WJCalendar {

    private lateinit var calendar: Calendar

    init {
        initCalendar()
    }

    override fun initCalendar() {
        calendar = Calendar.getInstance()
    }

    override fun setupCalendar(year: Int, month: Int) {
        calendar.run {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month.minus(1))
            set(Calendar.DAY_OF_MONTH, 1)
        }
    }

    override fun createBlankList(): List<WJCalendarEntity> {
        val firstDay = firstDayOfWeek()
        val blankList = mutableListOf<WJCalendarEntity>()

        for (i in 1 until firstDay) {
            WJCalendarEntity(
                type = WJCalendarType.BLANK,
                value = 0
            ).run {
                blankList.add(this)
            }
        }

        return blankList
    }

    override fun createDayList(): List<WJCalendarEntity> {
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dayList = mutableListOf<WJCalendarEntity>()

        createBlankList().run { dayList.addAll(this) }

        for (i in 1..lastDayOfMonth) {
            WJCalendarEntity(
                type = WJCalendarType.DAY,
                value = i
            ).run {
                dayList.add(this)
            }
        }

        return dayList
    }

    override fun firstDayOfWeek(): Int {
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    override fun lastDayOfMonth(): Int {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    override fun setYear(year: Int) {
        calendar.set(Calendar.YEAR, year)
    }

    override fun setMonth(month: Int) {
        calendar.set(Calendar.YEAR, month.minus(1))
    }

    override fun setDay(day: Int) {
        calendar.set(Calendar.YEAR, day)
    }

    override fun getYear(): Int {
        return calendar[Calendar.YEAR]
    }

    override fun getMonth(): Int {
        return calendar[Calendar.MONTH].plus(1)
    }

    override fun getDay(): Int {
        return calendar[Calendar.DAY_OF_MONTH]
    }

    override fun getCurrentDate(): String {
        return "${getYear()}년 ${getMonth()}월 ${getDay()}일"
    }

    override fun nextMonth() {
        TODO("Not yet implemented")
    }

    override fun beforeMonth() {
        TODO("Not yet implemented")
    }

}