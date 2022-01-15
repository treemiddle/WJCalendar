package com.jay.wjcalendarmodule.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setDay")
fun bindDay(tv: TextView, day: Int) {
    with(tv) {
        if (day == 0) {
            visibility = View.GONE
            text = null
        } else {
            visibility = View.VISIBLE
            text = day.toString()
        }
    }
}