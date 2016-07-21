package com.bolyartech.forge.android.misc;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;


@SuppressWarnings("unused")
public class AndroidOtto extends Bus {
    private final Handler mHandler = new Handler();


    public AndroidOtto() {
    }


    public AndroidOtto(String identifier) {
        super(identifier);
    }


    @Override
    public void post(final Object event) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    AndroidOtto.super.post(event);
                }
            });
        } else {
            AndroidOtto.super.post(event);
        }
    }
}
