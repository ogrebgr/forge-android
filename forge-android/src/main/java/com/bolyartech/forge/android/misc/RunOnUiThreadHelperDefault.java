package com.bolyartech.forge.android.misc;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;


public class RunOnUiThreadHelperDefault implements RunOnUiThreadHelper {
    private Handler handler = new Handler();


    @Inject
    public RunOnUiThreadHelperDefault() {

    }


    @Override
    public void runOnUiThread(Runnable r) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            handler.post(r);
        }
    }
}
