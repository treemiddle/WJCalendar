package com.jay.wjcalendarmodule

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.jay.wjcalendarmodule.calendar.WJCalendar
import com.jay.wjcalendarmodule.calendar.WJCalendarImpl
import com.jay.wjcalendarmodule.databinding.WjCalendarViewBinding
import com.jay.wjcalendarmodule.mapper.toDayColor
import com.jay.wjcalendarmodule.model.WJCalendarEntity
import com.jay.wjcalendarmodule.model.WJWeekColor

class WJCalendarView : ConstraintLayout {

    private val binding: WjCalendarViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.wj_calendar_view,
        this,
        true
    )

    private val calendarAdapter: WJCalendarDayAdapter = WJCalendarDayAdapter()

    private var currentDayColor = Color.BLACK
    private var currentDayFlag = false

    private var dayBackgroundColor = Color.BLACK
    private var beforeDrawable: Drawable? = null
    private var nextDrawable: Drawable? = null
    private var weekList = resources.getTextArray(R.array.week)
    private var weekColor = mutableListOf<WJWeekColor>()

    private lateinit var calendarWJ: WJCalendar

    constructor(context: Context) : super(context) {
        onCreate()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(attrs)
        onCreate()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
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
        val typedArray =
            context.obtainStyledAttributes(attributSet, R.styleable.WJCalendarView, defStyleAttr, 0)

        try {
            setTypeArray(typedArray)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setTypeArray(typeArray: TypedArray) {
        currentDayColor =
            typeArray.getColor(R.styleable.WJCalendarView_color_current_day, currentDayColor)
        currentDayFlag =
            typeArray.getBoolean(R.styleable.WJCalendarView_current_day, currentDayFlag)

        dayBackgroundColor = typeArray.getColor(
            R.styleable.WJCalendarView_wjcv_day_background_color,
            dayBackgroundColor
        )
        beforeDrawable = typeArray.getDrawable(R.styleable.WJCalendarView_wjcv_before_drawable)
        nextDrawable = typeArray.getDrawable(R.styleable.WJCalendarView_wjcv_next_drawable)

        val list = typeArray.getTextArray(R.styleable.WJCalendarView_android_entries)
        setWeekArray(list)
    }

    private fun onCreate() {
        calendarWJ = WJCalendarImpl()
        binding.rv.adapter = calendarAdapter
        calendarWJ.setupCalendar(
            calendarWJ.getYear(),
            calendarWJ.getMonth()
        )

        setDayBackgroundColor(createDayList())
        setHeaderTitle()
        initClickListener()
        setBeforeDrawable()
        setNextDrawable()
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

    private fun setBeforeDrawable() = beforeDrawable?.let { binding.ivBefore.background = it }

    private fun setNextDrawable() = nextDrawable?.let { binding.ivNext.background = it }

    private fun setWeekArray(charList: Array<CharSequence>?) {
        if (charList.isNullOrEmpty()) {
            weekList.forEachIndexed { index, charSequence ->
                setWeekTitle(
                    index,
                    charSequence.toString()
                )
            }
        } else {
            charList.forEachIndexed { index, charSequence ->
                setWeekTitle(
                    index,
                    charSequence.toString()
                )
            }
        }
    }

    private fun setWeekTitle(index: Int, value: String) = when (index) {
        0 -> binding.tvSun.text = value
        1 -> binding.tvMon.text = value
        2 -> binding.tvTue.text = value
        3 -> binding.tvWed.text = value
        4 -> binding.tvThu.text = value
        5 -> binding.tvFri.text = value
        6 -> binding.tvSat.text = value
        else -> throw IndexOutOfBoundsException("week title index over")
    }

    private fun setWeekTextColor(colors: List<WJWeekColor>) {
        for (i in colors.indices) {
            when (colors[i].week) {
                0 -> binding.tvSun.setTextColor(colors[i].color)
                1 -> binding.tvMon.setTextColor(colors[i].color)
                2 -> binding.tvTue.setTextColor(colors[i].color)
                3 -> binding.tvWed.setTextColor(colors[i].color)
                4 -> binding.tvThu.setTextColor(Color.GREEN)
                5 -> binding.tvFri.setTextColor(colors[i].color)
                6 -> binding.tvSat.setTextColor(colors[i].color)
                else -> throw IndexOutOfBoundsException("week text color index over")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setHeaderTitle() {
        binding.tvTitle.text = "${calendarWJ.getYear()}.${calendarWJ.getMonth()}"
    }

    fun setWeekColor(colors: List<WJWeekColor>) {
        weekColor.addAll(colors)

        setWeekTextColor(weekColor)
    }

}