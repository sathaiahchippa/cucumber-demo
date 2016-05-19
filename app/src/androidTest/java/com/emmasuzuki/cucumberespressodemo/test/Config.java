package com.emmasuzuki.cucumberespressodemo.test;

/**
 * Created by sathaiah on 2/7/16.
 */

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.emmasuzuki.cucumberespressodemo.MainActivity;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Config extends ActivityInstrumentationTestCase2 {

    private static boolean isFirstRun = true;
    public static Instrumentation instrumentation;

    public Config() {
        super(MainActivity.class);
    }

    @Before
    public void before() throws Exception {
        instrumentation = getInstrumentation();

        if (isFirstRun) {
            initializeEspresso();
            isFirstRun = false;
        } else {
            initializeEspresso();
        }
    }

    @After
    public void after() throws Throwable {
        finishOpenActivities();
    }

    private void initializeEspresso() {
        startFirstActivity();
    }

    private void startFirstActivity() {
        getActivity();
    }

    private void finishOpenActivities() {
        ActivityFinisher.finishOpenActivities();
    }
}