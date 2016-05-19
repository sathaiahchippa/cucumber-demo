package com.emmasuzuki.cucumberespressodemo.test;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;

import com.emmasuzuki.cucumberespressodemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sathaiah on 1/17/16.
 */
public class On {

    //Login screen objects - Starts
    public static final ViewInteraction LOGIN_EMAIL_TXT_BOX = onView(withId(R.id.email));
    public static final ViewInteraction LOGIN_PASSWORD_TXT_BOX = onView(withId(R.id.password));
    //public static final ViewInteraction LOGIN_SUBMIT_BUTTON = onView(withId(R.id.submit));
    public static final ViewInteraction LOGIN_TXT_BOX = onView(ViewMatchers.withId(R.id.edit_message));
    public static final ViewInteraction M_TXT = onView(withText("default"));
    public static final ViewInteraction LOGIN_SUBMIT_BUTTON = onView(withId(R.id.button_test));
}
