package com.mrbattery.abs

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.mrbattery.policy.GeneralRoundView18Policy
import com.mrbattery.policy.IRoundViewPolicy
import com.mrbattery.policy.SmoothCornerView18Policy
import com.mrbattery.policy.SmoothCornerView21Policy

/**
 * 平滑圆角布局实现类
 */
class SmoothCornerViewImpl(
    view: View, context: Context, attributeSet: AttributeSet?, attrs: IntArray, attrIndex: Int
) : IRoundView {

    private lateinit var smoothRoundViewPolicy: IRoundViewPolicy

    init {
        init(view, context, attributeSet, attrs, attrIndex)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        smoothRoundViewPolicy.onLayout(left, top, right, bottom)
    }

    fun beforeDispatchDraw(canvas: Canvas?) {
        smoothRoundViewPolicy.beforeDispatchDraw(canvas)
    }

    fun afterDispatchDraw(canvas: Canvas?) {
        smoothRoundViewPolicy.afterDispatchDraw(canvas)
    }

    private fun init(
        view: View,
        context: Context,
        attributeSet: AttributeSet?,
        attrs: IntArray,
        attrIndex: Int
    ) {

        smoothRoundViewPolicy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //L版本以上
            SmoothCornerView21Policy(view, context, attributeSet, attrs, attrIndex)
        } else {
            SmoothCornerView18Policy(view, context, attributeSet, attrs, attrIndex)
        }
    }

    override fun setCornerRadius(cornerRadius: Float) {
        smoothRoundViewPolicy.setCornerRadius(cornerRadius)
    }

}