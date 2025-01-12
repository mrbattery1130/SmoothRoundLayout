package com.mrbattery.policy

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mrbattery.getSmoothCornerRectPath

/**
 * 平滑圆角布局18、19、20版本策略
 *
 */
class SmoothCornerView18Policy(
    view: View, context: Context, attributeSet: AttributeSet?,
    attrs: IntArray,
    attrIndex: Int
) : AbsRoundViewPolicy(view, context, attributeSet, attrs, attrIndex) {

    init {
        initViewData()
    }

    private lateinit var mPaint: Paint
//    private lateinit var mRectF: RectF
    private lateinit var mPath: Path

    override fun beforeDispatchDraw(canvas: Canvas?) {
        canvas?.save()
    }

    override fun afterDispatchDraw(canvas: Canvas?) {
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    override fun onLayout(left: Int, top: Int, right: Int, bottom: Int) {
//        mRectF.set(0f, 0f, mContainer.width.toFloat(), mContainer.height.toFloat())
        resetRoundPath()
    }

    private fun initViewData() {
        //L版本以下
//        mRectF = RectF()
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        mPath = Path()
    }

    private fun resetRoundPath() {
        mPath.reset()
//        mPath.addRoundRect(mRectF, mCornerRadius, mCornerRadius, Path.Direction.CW)
        mPath.addPath(getSmoothCornerRectPath( mContainer.width, mContainer.height, mCornerRadius))
    }

    override fun setCornerRadius(cornerRadius: Float) {
        this.mCornerRadius = cornerRadius
        resetRoundPath()
    }
}