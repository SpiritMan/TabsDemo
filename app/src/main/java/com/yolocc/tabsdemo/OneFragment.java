package com.yolocc.tabsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.orhanobut.logger.LogLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 */
public class OneFragment extends Fragment {

    private ViewGroup anim_mask_layout;
    private View view;
    private Button cart,btnClick;
    int x,y;

    public OneFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("OneFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("OneFragment onCreateView");
        return view = inflater.inflate(R.layout.fragment_plus_one,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        btnClick = (Button) view.findViewById(R.id.btnClick);
        ArcTextView arcTextView = (ArcTextView) view.findViewById(R.id.arc_tv);
        arcTextView.setBorderColor(getResources().getColor(R.color.colorAccent));
        arcTextView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.wallet_holo_blue_light));
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(v);
            }
        });
        cart = (Button) view.findViewById(R.id.cart);
        CircleView circleView = (CircleView) view.findViewById(R.id.item_store_status_isopen);
        circleView.setBg(getResources().getColor(R.color.wallet_holo_blue_light));
        circleView.setText("你");
        System.out.println("OneFragment onStart");
        PieView pieView = (PieView) view.findViewById(R.id.pie_view);

        PieData pieData = new PieData("hhe",50);
        PieData pieData1 = new PieData("hhe",10);
        PieData pieData2 = new PieData("hhe",50);
        PieData pieData3 = new PieData("hhe",20);
        PieData pieData4 = new PieData("hhe",100);
        ArrayList<PieData> pieDataList = new ArrayList<>();
        pieDataList.add(pieData);
        pieDataList.add(pieData1);
        pieDataList.add(pieData2);
        pieDataList.add(pieData3);
        pieDataList.add(pieData4);
        pieView.setPieDatas(pieDataList);
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("OneFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("OneFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("OneFragment onStop");
    }

    private void click(View v) {
        int[] location = new int[2];
        btnClick.getLocationOnScreen(location);
        x = location[0];
        y = location[1];
        System.out.println("x:"+x+"y:"+y);
        int[] startLocation = new int[2];// Ò»¸öÕûÐÍÊý×é£¬ÓÃÀ´´æ´¢°´Å¥µÄÔÚÆÁÄ»µÄX¡¢Y×ø±ê
        cart.getLocationOnScreen(startLocation);
        x = startLocation[0];
        y = startLocation[1];
        System.out.println("x:"+x+"y:"+y);
        v.getLocationInWindow(location);// ÕâÊÇ»ñÈ¡¹ºÂò°´Å¥µÄÔÚÆÁÄ»µÄX¡¢Y×ø±ê£¨ÕâÒ²ÊÇ¶¯»­¿ªÊ¼µÄ×ø±ê£©
        ImageView ball = new ImageView(getActivity());
        ball.setImageResource(R.drawable.sign);// ÉèÖÃballµÄÍ¼Æ¬
//        setAnim(ball, startLocation);// ¿ªÊ¼Ö´ÐÐ¶¯»­
        setAddToCartAnim(getActivity(),ball,location,x,y);
    }

    private void setAnim(final View v, int[] startLocation) {
        anim_mask_layout = null;
        anim_mask_layout = createAnimLayout();
        anim_mask_layout.addView(v);// °Ñ¶¯»­Ð¡ÇòÌí¼Óµ½¶¯»­²ã
        final View view = addViewToAnimLayout(anim_mask_layout, v, startLocation);

        // ¼ÆËãÎ»ÒÆ

        TranslateAnimation translateAnimationX = new TranslateAnimation(0, x, 0, 0);
        translateAnimationX.setInterpolator(new LinearInterpolator());
        translateAnimationX.setRepeatCount(Animation.INFINITE);// ¶¯»­ÖØ¸´Ö´ÐÐµÄ´ÎÊý
        translateAnimationX.setFillAfter(true);

        TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0, 0, y);
        translateAnimationY.setInterpolator(new AccelerateInterpolator());
        translateAnimationY.setRepeatCount(Animation.INFINITE);// ¶¯»­ÖØ¸´Ö´ÐÐµÄ´ÎÊý
        translateAnimationX.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.setFillAfter(false);
        set.addAnimation(translateAnimationY);
        set.addAnimation(translateAnimationX);
        set.setDuration(2000);// ¶¯»­µÄÖ´ÐÐÊ±¼ä
        view.startAnimation(set);

        // ¶¯»­¼àÌýÊÂ¼þ
        set.setAnimationListener(new Animation.AnimationListener() {
            // ¶¯»­µÄ¿ªÊ¼
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            // ¶¯»­µÄ½áÊø
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
            }
        });

    }

    /**
     * @Description: ´´½¨¶¯»­²ã
     * @param
     * @return void
     * @throws
     */
    private ViewGroup createAnimLayout() {
        ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;
    }

    private View addViewToAnimLayout(final ViewGroup parent, final View view, int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    /**
     * 创建动画层
     *
     * @param activity 所属Activity
     * @return animLayout动画层
     */
    private ViewGroup createAnimLayout(Activity activity) {
        ViewGroup rootView = (ViewGroup) activity.getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
//        animLayout.setId(Integer.MAX_VALUE);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;
    }

    /**
     * 设置view的属性
     *
     * @param activity 所属activity
     * @param view     要执行动画的View
     * @param location 起始位置
     * @return view要执行动画的View
     */
    private View setViewProperty(final Activity activity, final View view,
                                 int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    /**
     * 设置添加购物车动画，使用补间动画
     *
     * @param activity       所属Activity
     * @param v              要执行动画的View
     * @param start_location 起始位置数组
     * @param endX           结束x点
     * @param endY           结束y点
     */
    public void setAddToCartAnim(Activity activity, final View v, int[] start_location, int endX, int endY) {
        LinearLayout anim_mask_layout = null;
        anim_mask_layout = (LinearLayout) createAnimLayout(activity);
        anim_mask_layout.addView(v);//把动画小球添加到动画层
        final View view = setViewProperty(activity, v,
                start_location);
/*-------------------------------------------设置动画-----------------------------------------------*/
        TranslateAnimation translateAnimationX = new TranslateAnimation(0,
                endX-start_location[0], 0, 0);
        translateAnimationX.setInterpolator(new LinearInterpolator());
        translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);

        TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
                0, (endY-start_location[1]));
        translateAnimationY.setInterpolator(new AccelerateInterpolator());
        translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);
        AnimationSet set = new AnimationSet(false);
        set.setFillAfter(false);
        set.addAnimation(translateAnimationY);
        set.addAnimation(translateAnimationX);
        set.setDuration(800);// 动画的执行时间
        view.startAnimation(set);
// 动画监听事件
        set.setAnimationListener(new Animation.AnimationListener() {
            // 动画的开始
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            // 动画的结束
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
            }
        });

    }
}
