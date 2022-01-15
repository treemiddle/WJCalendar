package com.jay.wjcalendarmodule

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jay.wjcalendarmodule.base.WJBaseListAdapter
import com.jay.wjcalendarmodule.base.WJBaseViewHolder
import com.jay.wjcalendarmodule.databinding.ItemDayBinding
import com.jay.wjcalendarmodule.model.WJCalendarEntity

class WJCalendarDayAdapter : WJBaseListAdapter<WJCalendarEntity>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WJBaseViewHolder<WJCalendarEntity> {
        return WJCalendarDayViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}