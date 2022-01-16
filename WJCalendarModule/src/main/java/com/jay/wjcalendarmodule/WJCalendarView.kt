package com.jay.wjcalendarmodule

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.jay.wjcalendarmodule.calendar.WJCalendar
import com.jay.wjcalendarmodule.calendar.WJCalendarImpl
import com.jay.wjcalendarmodule.calendar.WJCalendarType
import com.jay.wjcalendarmodule.databinding.WjCalendarViewBinding
import com.jay.wjcalendarmodule.mapper.toDayColor
import com.jay.wjcalendarmodule.model.WJCalendarEntity

fun calendarView(context: Context, block: WJCalendarView.WJBuilder.() -> Unit): WJCalendarView =
    WJCalendarView.WJBuilder(context).apply(block).build()

class WJCalendarView : ConstraintLayout {

    private val binding: WjCalendarViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.wj_calendar_view,
        this,
        true
    )

    private val calendarAdapter: WJCalendarDayAdapter = WJCalendarDayAdapter()

    private var dayBackgroundColor = Color.BLACK
    private var currentDayColor = Color.BLACK
    private var currentDayFlag = false

    private lateinit var calendarWJ: WJCalendar

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

    private fun onCreateByBuilder(builder: WJBuilder) {
        dayBackgroundColor = builder.dayBackgroundColor
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
        dayBackgroundColor = typeArray.getColor(R.styleable.WJCalendarView_day_background_color, dayBackgroundColor)
    }

    private fun onCreate() {
        calendarWJ = WJCalendarImpl()
        binding.rv.adapter = calendarAdapter
        calendarWJ.setupCalendar(2022, 1)

        setDayBackgroundColor(createDayList())
        setHeaderTitle()
        initClickListener()
    }

    private fun createDayList(): List<WJCalendarEntity> = calendarWJ.createDayList()

    private fun initClickListener() = with(binding) {
        ivBefore.setOnClickListener {
            setDayBackgroundColor(beforeMonth())
            setHeaderTitle()
        }
        ivNext.setOnClickListener {
            setDayBackgroundColor(nextMonth())
            setHeaderTitle()
        }
    }

    private fun beforeMonth(): List<WJCalendarEntity> = calendarWJ.beforeMonth()

    private fun nextMonth(): List<WJCalendarEntity> = calendarWJ.nextMonth()

    private fun calendarSubmitList(list: List<WJCalendarEntity>) = calendarAdapter.submitList(list)

    private fun setDayBackgroundColor(list: List<WJCalendarEntity>) {
        list.toDayColor(dayBackgroundColor)

        calendarSubmitList(list)
    }

    @SuppressLint("SetTextI18n")
    private fun setHeaderTitle() {
        val year = calendarWJ.getYear()
        val month = calendarWJ.getMonth()

        binding.tvTitle.text = "${year}.${month}"
    }

    class WJBuilder(val context: Context) {

        var dayBackgroundColor: Int = Color.BLACK

        fun setDayBackgroundColor(@ColorInt color: Int): WJBuilder = apply {
            this.dayBackgroundColor = color
        }

        fun build(): WJCalendarView = WJCalendarView(context).apply {
            onCreateByBuilder(this@WJBuilder)
        }
    }

}