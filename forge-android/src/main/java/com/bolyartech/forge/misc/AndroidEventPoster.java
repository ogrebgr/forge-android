package com.bolyartech.forge.misc;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;


public class AndroidEventPoster implements EventPoster {
    private final Handler mHandler = new Handler(Looper.getMainLooper());


    @Override
    public void postEvent(final Bus bus, final Object o) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    bus.post(o);
                }
            });
        } else {
            bus.post(o);
        }
    }
}
