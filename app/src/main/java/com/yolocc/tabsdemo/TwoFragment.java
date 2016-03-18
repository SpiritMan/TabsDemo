package com.yolocc.tabsdemo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 */
public class TwoFragment extends Fragment {

    public TwoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("TwoFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("TwoFragment onCreateView");
        return inflater.inflate(R.layout.fragment_plus_two,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("TwoFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("TwoFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("TwoFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("TwoFragment onStop");
    }
}
