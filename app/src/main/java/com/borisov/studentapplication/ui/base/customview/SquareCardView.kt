package com.borisov.studentapplication.ui.base.customview

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class SquareCardView(context : Context, attrs : AttributeSet) : MaterialCardView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasure: Int = heightMeasureSpec
        super.onMeasure(widthMeasure, heightMeasureSpec)
    }
}