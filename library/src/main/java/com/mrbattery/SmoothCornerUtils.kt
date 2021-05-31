package com.mrbattery

import android.graphics.Path
import android.util.Log
import kotlin.math.min

//class SmoothCornerUtils private constructor() {
//    companion object {
//
//        val instance: SmoothCornerUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            SmoothCornerUtils()
//        }
//    }
//}
fun getSmoothCornerRectPath(width: Int, height: Int, radius: Float): Path {
    Log.d("TAG", "getSmoothCornerRectPath: $width, $height, $radius")
    val path: Path = Path()

    val C = 0.551915024494f     // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置

    val mCircleRadius = min(width / 2f, height / 2f)                 // 圆的半径
    val mDifference = mCircleRadius * C       // 圆形的控制点与数据点的差值


    val mData = FloatArray(8) // 顺时针记录绘制圆形的四个数据点

    val mCtrl = FloatArray(16) // 顺时针记录绘制圆形的八个控制点


    // 初始化数据点

    mData[0] = 0f
    mData[1] = mCircleRadius

    mData[2] = mCircleRadius
    mData[3] = 0f

    mData[4] = 0f
    mData[5] = -mCircleRadius

    mData[6] = -mCircleRadius
    mData[7] = 0f

    // 初始化控制点

    mCtrl[0] = mData[0] + mDifference
    mCtrl[1] = mData[1]

    mCtrl[2] = mData[2]
    mCtrl[3] = mData[3] + mDifference

    mCtrl[4] = mData[2]
    mCtrl[5] = mData[3] - mDifference

    mCtrl[6] = mData[4] + mDifference
    mCtrl[7] = mData[5]

    mCtrl[8] = mData[4] - mDifference
    mCtrl[9] = mData[5]

    mCtrl[10] = mData[6]
    mCtrl[11] = mData[7] - mDifference

    mCtrl[12] = mData[6]
    mCtrl[13] = mData[7] + mDifference

    mCtrl[14] = mData[0] - mDifference
    mCtrl[15] = mData[1]


//    path.moveTo(mData[0], mData[1])

//    path.cubicTo(mCtrl[0], mCtrl[1], mCtrl[2], mCtrl[3], mData[2], mData[3])
//    path.cubicTo(mCtrl[4], mCtrl[5], mCtrl[6], mCtrl[7], mData[4], mData[5])
//    path.cubicTo(mCtrl[8], mCtrl[9], mCtrl[10], mCtrl[11], mData[6], mData[7])
//    path.cubicTo(mCtrl[12], mCtrl[13], mCtrl[14], mCtrl[15], mData[0], mData[1])

    path.lineTo(0f, 0f);
    path.lineTo(width.toFloat(), 0f);
    path.lineTo(0f, height.toFloat());
    path.close()
//    path.addRect(100f, 100f, width - 100f, height - 100f, Path.Direction.CW)
    return path

}