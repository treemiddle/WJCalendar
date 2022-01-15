package com.jay.wjcalendarmodule

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.jay.wjcalendarmodule.databinding.WjCalendarViewBinding
import com.jay.wjcalendarmodule.model.CalendarDay

class WJCalendarView : ConstraintLayout {

    private val binding: WjCalendarViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.wj_calendar_view,
        this,
        true
    )

    private val calendarAdapter: WJCalendarDayAdapter = WJCalendarDayAdapter()

    private var currentDayColor = Color.RED
    private var currentDayFlag = false

    constructor(context: Context) : super(context) {
        onCreate()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(attrs)
        onCreate()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super (
        context,
        attrs,
        defStyleAttr
    ) {
        getAttrs(attrs, defStyleAttr)
        onCreate()
    }

    private fun getAttrs(attributSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributSet, R.styleable.WJCalendarView)

        try {
            setTypeArray(typedArray)
        } finally {
            typedArray.recycle()
        }
    }

    private fun getAttrs(attributSet: AttributeSet, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attributSet, R.styleable.WJCalendarView, defStyleAttr, 0)

        try {
            setTypeArray(typedArray)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setTypeArray(typeArray: TypedArray) {
        currentDayColor = typeArray.getColor(R.styleable.WJCalendarView_color_current_day, currentDayColor)
        currentDayFlag = typeArray.getBoolean(R.styleable.WJCalendarView_current_day, currentDayFlag)
    }

    private fun onCreate() {
        binding.rv.adapter = calendarAdapter
        test()
    }

    private fun test() {
        val list = mutableListOf<CalendarDay>().apply {
            for (i in 1..30) {
                add(CalendarDay(i.toString()))
            }
        }

        calendarAdapter.submitList(list)
    }

}