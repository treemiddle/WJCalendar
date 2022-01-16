package com.jay.wjcalendarmodule

import com.jay.wjcalendarmodule.calendar.WJCalendarImpl
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalendarTest {

    lateinit var impl: WJCalendarImpl

    @Before
    fun init() {
        impl = WJCalendarImpl()
        impl.initCalendar()
    }

    @Test
    fun `1_캘린더를 2022년 1월로 초기화 하고 반환 값은 2022년 1월 1일 이다`() {
        impl.setupCalendar(2022, 1)

        Assert.assertEquals(
            "2022년 1월 1일",
            impl.getCurrentDate()
        )
    }

    @Test
    fun `2_2022년 1월의 시작요일은 토요일(7)이다`() {
        impl.setupCalendar(2022, 1)

        Assert.assertEquals(7, impl.firstDayOfWeek())
    }

    @Test
    fun `3_2022년 1월의 마지막 일은 31일이다`() {
        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `4_캘린더를 2월로 초기화 한다`() {
        impl.setMonth(2)

        Assert.assertEquals(2, impl.getMonth())
    }

    @Test
    fun `5_2022년 2월의 시작요일은 화요일(3)이다`() {
        impl.setupCalendar(2022, 2)

        Assert.assertEquals(3, impl.firstDayOfWeek())
    }

    @Test
    fun `6_2022년 2월의 마지막 일은 28일이다`() {
        impl.setupCalendar(2022, 2)

        Assert.assertEquals(28, impl.lastDayOfMonth())
    }

    @Test
    fun `7_캘린더를 3월로 초기화 한다`() {
        impl.setMonth(3)

        Assert.assertEquals(3, impl.getMonth())
    }

    @Test
    fun `8_2022년 2월의 시작요일은 화요일(3)이다`() {
        impl.setupCalendar(2022, 2)

        Assert.assertEquals(3, impl.firstDayOfWeek())
    }

    @Test
    fun `9_2022년 2월의 마지막 일은 31일이다`() {
        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `10_캘린더를 4월로 초기화 한다`() {
        impl.setMonth(4)

        Assert.assertEquals(4, impl.getMonth())
    }

    @Test
    fun `11_2022년 4월의 시작요일은 금요일(6)이다`() {
        impl.setupCalendar(2022, 4)

        Assert.assertEquals(6, impl.firstDayOfWeek())
    }

    @Test
    fun `12_2022년 4월의 마지막 일은 30일이다`() {
        impl.setupCalendar(2022, 4)

        Assert.assertEquals(30, impl.lastDayOfMonth())
    }

    @Test
    fun `13_캘린더를 5월로 초기화 한다`() {
        impl.setMonth(5)

        Assert.assertEquals(5, impl.getMonth())
    }

    @Test
    fun `14_2022년 5월의 시작요일은 일요일(1)이다`() {
        impl.setupCalendar(2022, 5)

        Assert.assertEquals(1, impl.firstDayOfWeek())
    }

    @Test
    fun `15_2022년 5월의 마지막 일은 31일이다`() {
        impl.setupCalendar(2022, 5)

        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `16_캘린더를 6월로 초기화 한다`() {
        impl.setMonth(6)

        Assert.assertEquals(6, impl.getMonth())
    }

    @Test
    fun `17_2022년 6월의 시작요일은 수요일(4)이다`() {
        impl.setupCalendar(2022, 6)

        Assert.assertEquals(4, impl.firstDayOfWeek())
    }

    @Test
    fun `18_2022년 6월의 마지막 일은 30일이다`() {
        impl.run {
            setYear(2022)
            setMonth(6)
            setDay(1)
        }

        Assert.assertEquals(30, impl.lastDayOfMonth())
    }

    @Test
    fun `19_캘린더를 7월로 초기화 한다`() {
        impl.setMonth(7)

        Assert.assertEquals(7, impl.getMonth())
    }

    @Test
    fun `20_2022년 7월의 시작요일은 금요일(6)이다`() {
        impl.setupCalendar(2022, 7)

        Assert.assertEquals(6, impl.firstDayOfWeek())
    }

    @Test
    fun `21_2022년 7월의 마지막 일은 31일이다`() {
        impl.setupCalendar(2022, 7)

        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `22_캘린더를 8월로 초기화 한다`() {
        impl.setMonth(8)

        Assert.assertEquals(8, impl.getMonth())
    }

    @Test
    fun `23_2022년 8월의 시작요일은 월요일(2)이다`() {
        impl.setupCalendar(2022, 8)

        Assert.assertEquals(2, impl.firstDayOfWeek())
    }

    @Test
    fun `24_2022년 8월의 마지막 일은 31일이다`() {
        impl.setupCalendar(2022, 8)

        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `25_캘린더를 9월로 초기화 한다`() {
        impl.setMonth(9)

        Assert.assertEquals(9, impl.getMonth())
    }

    @Test
    fun `26_2022년 9월의 시작요일은 목요일(5)이다`() {
        impl.setupCalendar(2022, 9)

        Assert.assertEquals(5, impl.firstDayOfWeek())
    }

    @Test
    fun `27_2022년 9월의 마지막 일은 30일이다`() {
        impl.setupCalendar(2022, 9)

        Assert.assertEquals(30, impl.lastDayOfMonth())
    }

    @Test
    fun `28_캘린더를 10월로 초기화 한다`() {
        impl.setMonth(10)

        Assert.assertEquals(10, impl.getMonth())
    }

    @Test
    fun `29_2022년 10월의 시작요일은 토요일(7)이다`() {
        impl.setupCalendar(2022, 10)

        Assert.assertEquals(7, impl.firstDayOfWeek())
    }

    @Test
    fun `30_2022년 10월의 마지막 일은 31일이다`() {
        impl.setupCalendar(2022, 10)

        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @Test
    fun `31_캘린더를 11월로 초기화 한다`() {
        impl.setMonth(11)

        Assert.assertEquals(11, impl.getMonth())
    }

    @Test
    fun `32_2022년 11월의 시작요일은 화요일(3)이다`() {
        impl.setupCalendar(2022, 11)

        Assert.assertEquals(3, impl.firstDayOfWeek())
    }

    @Test
    fun `33_2022년 11월의 마지막 일은 30일이다`() {
        impl.setupCalendar(2022, 11)

        Assert.assertEquals(30, impl.lastDayOfMonth())
    }

    @Test
    fun `34_캘린더를 12월로 초기화 한다`() {
        impl.setMonth(12)

        Assert.assertEquals(12, impl.getMonth())
    }

    @Test
    fun `35_2022년 12월의 시작요일은 목요일(5)이다`() {
        impl.setupCalendar(2022, 12)

        Assert.assertEquals(5, impl.firstDayOfWeek())
    }

    @Test
    fun `36_2022년 12월의 마지막 일은 31일이다`() {
        impl.setupCalendar(2022, 12)

        Assert.assertEquals(31, impl.lastDayOfMonth())
    }

    @After
    fun finish() {

    }

}