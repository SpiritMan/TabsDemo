package com.yolocc.tabsdemo;

import android.app.Activity;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;


/**
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class SampleActivityTest {

    public void textHomeActivity() {
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class).create().start();
        Activity activity = activityController.get();
    }
}
