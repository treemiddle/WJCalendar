package com.jay.wjcalendarmodule

import com.jay.wjcalendarmodule.base.WJBaseViewHolder
import com.jay.wjcalendarmodule.databinding.ItemDayBinding
import com.jay.wjcalendarmodule.model.WJCalendarEntity

class WJCalendarDayViewHolder(
    private val binding: ItemDayBinding
) : WJBaseViewHolder<WJCalendarEntity>(binding) {

    override fun bind(item: WJCalendarEntity) {
        binding.item = item
        binding.executePendingBindings()
    }

}