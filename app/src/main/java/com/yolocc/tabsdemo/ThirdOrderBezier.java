package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 贝塞尔曲线三阶
 */
public class ThirdOrderBezier extends View {

    private Paint mPaint;
    private int centerX, centerY;
    private PointF start, end, control1, control2;
    private boolean mode = false;

    public ThirdOrderBezier(Context context) {
        super(context);
        initPaint();
    }

    public ThirdOrderBezier(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ThirdOrderBezier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control1 = new PointF(0, 0);
        control2 = new PointF(0, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        start.x = centerX - 200;
        start.y = centerY;
        end.x = centerX + 200;
        end.y = centerY;
        control1.x = centerX - 200;
        control1.y = centerY - 200;
        control2.x = centerX + 200;
        control2.y = centerY - 200;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mode) {
            control2.x = event.getX();
            control2.y = event.getY();
        } else {
            control1.x = event.getX();
            control1.y = event.getY();
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(start.x, start.y, 10, mPaint);
        canvas.drawCircle(end.x, end.y, 10, mPaint);
        canvas.drawCircle(control1.x, control1.y, 10, mPaint);
        canvas.drawCircle(control2.x, control2.y, 10, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x, start.y, control1.x, control1.y, mPaint);
        canvas.drawLine(control1.x, control1.y, control2.x, control2.y, mPaint);
        canvas.drawLine(control2.x, control2.y, end.x, end.y, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path = new Path();

        path.moveTo(start.x, start.y);
        path.cubicTo(control1.x, control1.y, control2.x, control2.y, end.x, end.y);

        canvas.drawPath(path,mPaint);

        super.onDraw(canvas);
    }
}
