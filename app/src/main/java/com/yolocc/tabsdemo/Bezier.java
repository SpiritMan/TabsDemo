package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 */
public class Bezier extends View {

    private Paint mPaint;
    private int centerX, centerY;
    private PointF start, end, control, origin;
    private boolean isActionUp = false;

    public Bezier(Context context) {
        super(context);
        initPaint();
    }

    public Bezier(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Bezier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);
        mPaint.setAntiAlias(true);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);
        origin = new PointF(0, 0);
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
        control.x = centerX;
        control.y = centerY - 200;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        control.x = event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                isActionUp = false;
                control.y = event.getY();
                control.x = event.getX();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                isActionUp = true;
                control.x = centerX;
                control.y = centerY + 50;
                setControlY();
                origin.x = event.getX();
                origin.y = event.getY();
//                control.y = event.getY();
                System.out.println("control Y:" + control.y);
//                setPoint();
                break;
        }
        return true;
    }

    private void setControlY() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (control.y > centerY) {
                    control.y = control.y - 10;
                } else {
                    control.y = control.y + 10;
                }
                invalidate();
            }
        }, 100);
    }

    private void setPoint() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                origin.x = origin.x - 10;
                origin.y = origin.y - 10;
                invalidate();
            }
        }, 10);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(start.x, start.y, 10, mPaint);
        canvas.drawCircle(end.x, end.y, 10, mPaint);
//        canvas.drawCircle(control.x, control.y, 10, mPaint);

        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawLine(start.x, start.y, control.x, control.y, mPaint);
//        canvas.drawLine(control.x, control.y, end.x, end.y, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path = new Path();
        path.moveTo(start.x, start.y);
        path.quadTo(control.x, control.y, end.x, end.y);

        canvas.drawPath(path, mPaint);
//        if (origin.x >= 0) {
//            mPaint.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(origin.x, origin.y, 10, mPaint);
//            setPoint();
//        }
        if (isActionUp && control.y != centerY) {
            setControlY();
        }
    }
}
