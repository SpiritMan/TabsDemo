package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 */
public class PieView extends View {

    // 颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private ArrayList<PieData> mPieDatas;

    private int width, height;

    private int paddingLeft, paddingRight, paddingTop, paddingBottom;

    private Paint mPaint = new Paint();

    private float mStartAngle = 0;


    public PieView(Context context) {
        super(context);

    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPieDatas == null) {
            return;
        }

        float currentStartAngle = mStartAngle;
        // 将坐标系原点移动到画布正中心
        canvas.translate((width + paddingLeft + paddingRight) / 2, (height + paddingTop + paddingBottom) / 2);
        float r = (float) (Math.min(width, height) / 2 * 0.8);
        RectF rectF = new RectF(-r, -r, r, r);

        for (PieData pieData : mPieDatas) {
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rectF, currentStartAngle, pieData.getAngle(), true, mPaint);
            currentStartAngle = currentStartAngle + pieData.getAngle();
        }

    }

    public void setPieDatas(ArrayList<PieData> mPieDatas) {
        this.mPieDatas = mPieDatas;
        initData(mPieDatas);
        invalidate();
    }

    private void initData(ArrayList<PieData> mPieDatas) {
        if (mPieDatas == null || mPieDatas.size() == 0) {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < mPieDatas.size(); i++) {
            PieData piedata = mPieDatas.get(i);
            sumValue = sumValue + piedata.getValue();
            int j = i % mColors.length;
            piedata.setColor(mColors[j]);
        }

        for (PieData mPieData : mPieDatas) {
            float percentage = mPieData.getValue() / sumValue;
            float angle = percentage * 360;
            mPieData.setPercentage(percentage);
            mPieData.setAngle(angle);
        }
    }

}
