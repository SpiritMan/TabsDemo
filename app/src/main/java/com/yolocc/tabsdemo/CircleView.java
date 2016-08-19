/*
 * -----------------------------
 * Copyright (C) 2016, 上海宅米贸易有限公司, All rights reserved.
 * -----------------------------
 * File: CircleView.java
 * Author: LongLe
 *
 */

package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 */
public class CircleView extends TextView {

    private Paint mBgPaint = new Paint();

    PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBgPaint.setColor(getResources().getColor(R.color.colorAccent));
        mBgPaint.setAntiAlias(true);
    }

    public CircleView(Context context) {
        super(context);
        mBgPaint.setColor(getResources().getColor(R.color.colorAccent));
        mBgPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        System.out.println("onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        setMeasuredDimension(max, max);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        System.out.println("onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setBg(@ColorInt int color) {
        System.out.println("setBg");
        mBgPaint.setColor(color);
//        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        System.out.println("draw");
        canvas.setDrawFilter(pfd);
        canvas.drawCircle(getWidth()/2, getHeight()/2, Math.max(getWidth(), getHeight())/2, mBgPaint);
        super.onDraw(canvas);
    }
}