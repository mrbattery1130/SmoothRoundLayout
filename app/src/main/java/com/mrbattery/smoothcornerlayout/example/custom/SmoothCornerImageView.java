package com.mrbattery.smoothcornerlayout.example.custom;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import android.util.AttributeSet;

import com.mrbattery.abs.IRoundView;
import com.mrbattery.abs.SmoothCornerViewImpl;
import com.mrbattery.smoothcornerlayout.example.R;

/**
 * 自定义view增加圆角裁剪
 */
public class SmoothCornerImageView extends AppCompatImageView implements IRoundView {
    private SmoothCornerViewImpl viewImpl;

    public SmoothCornerImageView(Context context) {
        this(context, null);
    }

    public SmoothCornerImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(this, context, attrs);
    }


    public SmoothCornerImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(this, context, attrs);
    }

    @Override
    public void setCornerRadius(float cornerRadius) {
        viewImpl.setCornerRadius(cornerRadius);
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        viewImpl.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        viewImpl.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        viewImpl.afterDispatchDraw(canvas);
    }

    private void init(SmoothCornerImageView view, Context context, AttributeSet attrs) {
        viewImpl = new SmoothCornerViewImpl(view,
                context,
                attrs,
                R.styleable.GeneralRoundImageView,
                R.styleable.GeneralRoundImageView_corner_radius);
    }

}
