package com.mrbattery.policy

import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import com.mrbattery.getSmoothCornerRectPath

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
//                outline.setRoundRect(0, 0, mContainer.width, mContainer.height, mCornerRadius)
//                val path = Path()
//                getSmoothCornerRectPath(mContainer.width, mContainer.height, mCornerRadius)
//                path.reset()
//                path.addRect(
//                    100f,
//                    100f,
//                    mContainer.width - 100f,
//                    mContainer.height - 100f,
//                    Path.Direction.CW
//                )

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    outline.setPath(buildConvexPath())
                } else {
                    outline.setConvexPath(buildConvexPath())
                }
//                view.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            }

            fun buildConvexPath(): Path {
                val path = Path()
                path.lineTo(0f, 0f)
                path.lineTo(mContainer.width.toFloat(), 0f)
                path.lineTo(0f, mContainer.height.toFloat())
                path.close()
                return path
            }
        }
    }

    override fun onLayout(left: Int, top: Int, right: Int, bottom: Int) {
    }

}