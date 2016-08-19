package com.yolocc.tabsdemo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 */
public class ArcTextView extends TextView {

    private final int default_background_color = Color.WHITE;
    private final int default_border_color = Color.WHITE;
    private final float default_border_stroke_width;

    private Paint mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Paint mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private RectF mLeftCornerRectF = new RectF();

    private RectF mRightCornerRectF = new RectF();

    private RectF mHorizontalBlankFillRectF = new RectF();

    private RectF mVerticalBlankFillRectF = new RectF();

    private Path mBorderPath = new Path();

    private int borderStrokeWidth;

    private int horizontalPadding;
    private int verticalPadding;

    // 背景颜色
    private int backgroundColor;
    //边框颜色
    private int borderColor;


    public ArcTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        horizontalPadding = (int) dp2px(12.0f);
        verticalPadding = (int) dp2px(3.0f);
        default_border_stroke_width = dp2px(1.0f);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ArcTextView);
        backgroundColor = typedArray.getColor(R.styleable.ArcTextView_arc_backgroundColor, default_background_color);
        borderColor = typedArray.getColor(R.styleable.ArcTextView_arc_borderColor, default_border_color);
        borderStrokeWidth = (int)typedArray.getDimension(R.styleable.ArcTextView_arc_borderWidth,default_border_stroke_width);

        typedArray.recycle();
        setGravity(Gravity.CENTER);

        setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        mBorderPaint.setColor(borderColor);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(borderStrokeWidth);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(backgroundColor);
    }

    public void setBorderColor(@ColorInt int color) {
        if(color == borderColor) {
            return;
        }
        borderColor = color;
        mBorderPaint.setColor(borderColor);
        invalidate();
    }

    public void setBackgroundColor(@ColorInt int color) {
        if(color == backgroundColor) {
            return;
        }
        backgroundColor = color;
        mBackgroundPaint.setColor(backgroundColor);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(mLeftCornerRectF, -180, 90, true, mBackgroundPaint);
        canvas.drawArc(mLeftCornerRectF, -270, 90, true, mBackgroundPaint);
        canvas.drawArc(mRightCornerRectF, -90, 90, true, mBackgroundPaint);
        canvas.drawArc(mRightCornerRectF, 0, 90, true, mBackgroundPaint);
        canvas.drawRect(mHorizontalBlankFillRectF, mBackgroundPaint);
        canvas.drawRect(mVerticalBlankFillRectF, mBackgroundPaint);
        canvas.drawPath(mBorderPath, mBorderPaint);
        super.onDraw(canvas);
    }
    

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int left = borderStrokeWidth;
        int top = borderStrokeWidth;
        int right = (left + w - borderStrokeWidth * 2);
        int bottom = (top + h - borderStrokeWidth * 2);

        int d = bottom - top;

        mLeftCornerRectF.set(left, top, left + d, top + d);
        mRightCornerRectF.set(right - d, top, right, top + d);

        mBorderPath.reset();
        mBorderPath.addArc(mLeftCornerRectF, -180, 90);
        mBorderPath.addArc(mLeftCornerRectF, -270, 90);
        mBorderPath.addArc(mRightCornerRectF, -90, 90);
        mBorderPath.addArc(mRightCornerRectF, 0, 90);

        int l = (int) (d / 2.0f);
        mBorderPath.moveTo(left + l, top);
        mBorderPath.lineTo(right - l, top);

        mBorderPath.moveTo(left + l, bottom);
        mBorderPath.lineTo(right - l, bottom);

        mBorderPath.moveTo(left, top + l);
        mBorderPath.lineTo(left, bottom - l);

        mBorderPath.moveTo(right, top + l);
        mBorderPath.lineTo(right, bottom - l);

        mHorizontalBlankFillRectF.set(left, top + l, right, bottom - l);
        mVerticalBlankFillRectF.set(left + l, top, right - l, bottom);

    }

    public float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }
}
