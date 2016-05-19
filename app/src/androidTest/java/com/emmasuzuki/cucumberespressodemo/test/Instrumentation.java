/*
 * Copyright (C) 2015 emmasuzuki <emma11suzuki@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.emmasuzuki.cucumberespressodemo.test;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;

//Not login means, it will execute all scripts except login. This is the reason, when I did ~@login, ~@logout - it executed all scripts - because not login executed logout scripts and not logout executed all login scripts.
//"@sample, @sample2, ~@login" - this executes, sample, sample2 and all scripts except login - so all logout scripts will be executed
@CucumberOptions(plugin = {"pretty"}, features = "features", tags = { "@sample222" }, monochrome = true)
public class Instrumentation extends MonitoringInstrumentation {

    private static final String TAGS_KEY = "tags";

    private final CucumberInstrumentationCore mInstrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);

        // Reading runner params
        String tags = com.emmasuzuki.cucumberespressodemo.test.BuildConfig.TAGS;
        if (!tags.isEmpty()) {
            bundle.putString(TAGS_KEY, tags);
        }

        mInstrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();

        waitForIdleSync();
        mInstrumentationCore.start();
    }


}
