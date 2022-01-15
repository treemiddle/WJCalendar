package com.jay.wjcalendarmodule

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jay.wjcalendarmodule.base.WJBaseListAdapter
import com.jay.wjcalendarmodule.base.WJBaseViewHolder
import com.jay.wjcalendarmodule.databinding.ItemDayBinding
import com.jay.wjcalendarmodule.model.CalendarDay

class WJCalendarDayAdapter : WJBaseListAdapter<CalendarDay>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WJBaseViewHolder<CalendarDay> {
        return WJCalendarDayViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}