package com.jay.wjcalendarmodule.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jay.wjcalendarmodule.R

class WJHeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int? = null
) : LinearLayout(context) {

    var headerPaddingTop = 4f
    var headerPaddingBottom = 4f
    var headerPaddingLeft = 4f
    var headerPaddingRight = 4f
    var headerBackgroundColor = Color.WHITE
    var beforeDrawable: Drawable? = null
    var nextDrawable: Drawable? = null
    var titleText: String? = null
    var titleColor = Color.BLACK
    var titleSize = 12f
    var titleStyle = Typeface.NORMAL

    init {
        onCreate()

        when {
            attrs != null && defStyleAttr != null -> getAttrs(attrs, defStyleAttr)
            attrs != null -> getAttrs(attrs)
        }
    }

    private fun onCreate() {

    }

    private fun getAttrs(attribuSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attribuSet, R.styleable.WJHeaderView)

        try {
            setTypeArray(typedArray)
        } finally {
            typedArray.recycle()
        }
    }

    private fun getAttrs(attrs: AttributeSet, defStyleAttr: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.WJHeaderView, defStyleAttr, 0)

        try {
            setTypeArray(typedArray)
        } finally {
            typedArray.recycle()
        }
    }

    private fun setTypeArray(typeArray: TypedArray) {
        headerPaddingTop = typeArray.getDimension(R.styleable.WJHeaderView_header_padding_top, headerPaddingTop)
        headerPaddingBottom = typeArray.getDimension(R.styleable.WJHeaderView_header_padding_bottom, headerPaddingBottom)
        headerPaddingLeft = typeArray.getDimension(R.styleable.WJHeaderView_header_padding_left, headerPaddingLeft)
        headerPaddingRight = typeArray.getDimension(R.styleable.WJHeaderView_header_padding_right, headerPaddingRight)
        headerBackgroundColor = typeArray.getColor(R.styleable.WJHeaderView_header_background_color, headerBackgroundColor)
        beforeDrawable = typeArray.getDrawable(R.styleable.WJHeaderView_header_before_drawable)
        nextDrawable = typeArray.getDrawable(R.styleable.WJHeaderView_header_next_drawable)
        titleText = typeArray.getString(R.styleable.WJHeaderView_header_title_text)
        titleColor = typeArray.getColor(R.styleable.WJHeaderView_header_title_textColor, titleColor)
        titleSize = typeArray.getDimension(R.styleable.WJHeaderView_header_title_textSize, titleSize)
        titleStyle = typeArray.getType(R.styleable.WJHeaderView_header_title_textStyle)
    }

}