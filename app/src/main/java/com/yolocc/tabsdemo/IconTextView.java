package com.yolocc.tabsdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 */
public class IconTextView extends TextView{
    public IconTextView(Context context) {
        super(context);
        if (!isInEditMode())
            init(context);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init(context);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            init(context);
    }


    private void init(Context context) {

        Typeface t = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        this.setTypeface(t);
    }
}
