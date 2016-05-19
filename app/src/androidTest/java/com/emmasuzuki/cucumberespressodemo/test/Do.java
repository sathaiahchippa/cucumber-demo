package com.emmasuzuki.cucumberespressodemo.test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;

/**
 * Created by sathaiah on 1/17/16.
 */
public class Do {

    //Login method
    public static void login(String username, String password) {
        On.LOGIN_EMAIL_TXT_BOX.perform(typeText(username));
        On.LOGIN_PASSWORD_TXT_BOX.perform(typeText(password));
        On.LOGIN_SUBMIT_BUTTON.perform(click());
        pressBack();
    }

    //Clear app info method
    public static void clearPreferences() {
        try {
            // clearing app data
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear YOUR_APP_PACKAGE_GOES HERE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
