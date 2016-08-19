package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 */
public class CustomView extends View {

    Paint mPaint, mWhitePaint, mRedPaint;
    private int mSweepAngle;

    public CustomView(Context context) {
        super(context);
        initPaint();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mWhitePaint = new Paint();
        mWhitePaint.setColor(Color.WHITE);
        mWhitePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        mWhitePaint.setStrokeCap(Paint.Cap.ROUND);
        mWhitePaint.setStrokeJoin(Paint.Join.ROUND);
        mWhitePaint.setStrokeWidth(3);
        mWhitePaint.setStyle(Paint.Style.STROKE);
        mRedPaint = new Paint();
        mRedPaint.setColor(Color.RED);
        mRedPaint.setStrokeCap(Paint.Cap.ROUND);
        mRedPaint.setStrokeJoin(Paint.Join.ROUND);
        mRedPaint.setStrokeWidth(3);
        mRedPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(100, 100, 300, 300);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawRect(rectF, paint);
        canvas.drawCircle(200, 200, 100, mPaint);
        canvas.drawArc(rectF, 0, mSweepAngle, false, mRedPaint);
        if (mSweepAngle < 360) {
            setSweepAngel();
        } else {
            canvas.drawText("over",200,200,mPaint);
        }
    }

    private void setSweepAngel() {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                mSweepAngle = mSweepAngle + 1;
                invalidate();
            }
        }, 10);

    }
}
