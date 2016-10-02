package com.bolyartech.forge.android.misc;

import android.os.SystemClock;

import com.bolyartech.forge.base.misc.TimeProvider;


/**
 * Android specific implementation of {@link TimeProvider}
 */
public class AndroidTimeProvider implements TimeProvider {

    @Override
    public long getVmTime() {
        return SystemClock.elapsedRealtime();
    }


    @Override
    public long getWallClockTime() {
        return System.currentTimeMillis();
    }
}
