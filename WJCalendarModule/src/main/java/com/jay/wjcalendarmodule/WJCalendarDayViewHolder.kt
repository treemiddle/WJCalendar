package com.jay.wjcalendarmodule

import com.jay.wjcalendarmodule.base.WJBaseViewHolder
import com.jay.wjcalendarmodule.databinding.ItemDayBinding
import com.jay.wjcalendarmodule.model.CalendarDay

class WJCalendarDayViewHolder(
    private val binding: ItemDayBinding
) : WJBaseViewHolder<CalendarDay>(binding) {

    override fun bind(item: CalendarDay) {
        binding.day = item
        binding.executePendingBindings()
    }

}