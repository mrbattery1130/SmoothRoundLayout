package com.mrbattery.abs

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.mrbattery.policy.GeneralRoundView18Policy
import com.mrbattery.policy.GeneralRoundView21Policy
import com.mrbattery.policy.IRoundViewPolicy

/**
 * 通用圆角布局实现类
 * @author minminaya
 * @email minminaya@gmail.com
 * @time Created by 2019/6/7 21:54
 *
 */
class GeneralRoundViewImpl(view: View, context: Context, attributeSet: AttributeSet?, attrs: IntArray, attrIndex: Int) :
    IRoundView {

    private lateinit var generalRoundViewPolicy: IRoundViewPolicy

    init {
        init(view, context, attributeSet, attrs, attrIndex)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        generalRoundViewPolicy.onLayout(left, top, right, bottom)
    }

    fun beforeDispatchDraw(canvas: Canvas?) {
        generalRoundViewPolicy.beforeDispatchDraw(canvas)
    }

    fun afterDispatchDraw(canvas: Canvas?) {
        generalRoundViewPolicy.afterDispatchDraw(canvas)
    }

    private fun init(view: View, context: Context, attributeSet: AttributeSet?, attrs: IntArray, attrIndex: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //L版本以上
            generalRoundViewPolicy = GeneralRoundView21Policy(view, context, attributeSet, attrs, attrIndex)
        } else {
            generalRoundViewPolicy = GeneralRoundView18Policy(view, context, attributeSet, attrs, attrIndex)
        }
    }

    override fun setCornerRadius(cornerRadius: Float) {
        generalRoundViewPolicy.setCornerRadius(cornerRadius)
    }

}