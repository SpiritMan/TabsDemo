package com.yolocc.tabsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 */
public class ThreeFragment extends Fragment {

    private View view;

    public ThreeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("ThreeFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("ThreeFragment onCreateView");
        view = inflater.inflate(R.layout.fragment_plus_three,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        WebView webView = (WebView) view.findViewById(R.id.web_view);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("myapp://jp.app/openwith?name=zhangsan&age=26");
        System.out.println("ThreeFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("ThreeFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("ThreeFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("ThreeFragment onStop");
    }
}
