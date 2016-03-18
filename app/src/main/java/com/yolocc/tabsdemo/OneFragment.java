package com.yolocc.tabsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 */
public class OneFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_plus_one,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("OneFragment onStart");
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
}
