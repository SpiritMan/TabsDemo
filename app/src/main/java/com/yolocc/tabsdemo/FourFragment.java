package com.yolocc.tabsdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 */
public class FourFragment extends Fragment {

    private View view;

    public FourFragment() {
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
        view = inflater.inflate(R.layout.fragment_plus_four,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
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
