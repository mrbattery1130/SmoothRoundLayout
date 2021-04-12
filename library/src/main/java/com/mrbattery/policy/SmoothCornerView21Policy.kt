package com.mrbattery.policy

import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider

/**
 * 平滑圆角布局L版本以上策略
 */
class SmoothCornerView21Policy(
    view: View, context: Context, attributeSet: AttributeSet?, attrs: IntArray, attrIndex: Int
) : AbsRoundViewPolicy(view, context, attributeSet, attrs, attrIndex) {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun beforeDispatchDraw(canvas: Canvas?) {
        //Android L版本以上，采用ViewOutlineProvider来裁剪view
        mContainer.clipToOutline = true
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun afterDispatchDraw(canvas: Canvas?) {
        //Android L版本以上，采用ViewOutlineProvider来裁剪view
        mContainer.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, mContainer.width, mContainer.height, mCornerRadius)
            }
        }
    }

    override fun onLayout(left: Int, top: Int, right: Int, bottom: Int) {
    }

}