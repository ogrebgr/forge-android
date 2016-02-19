package com.bolyartech.forge.android.misc;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

import javax.inject.Inject;


public class AndroidEventPoster implements EventPoster {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final Bus mBus;


    @Inject
    public AndroidEventPoster(Bus bus) {
        mBus = bus;
    }


    @Override
    public void postEvent(final Object o) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mBus.post(o);
                }
            });
        } else {
            mBus.post(o);
        }
    }
}
