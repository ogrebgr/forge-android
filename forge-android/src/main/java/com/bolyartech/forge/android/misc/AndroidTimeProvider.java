package com.bolyartech.forge.android.misc;

import android.os.SystemClock;

import com.bolyartech.forge.base.misc.TimeProvider;


/**
 * Android specific implementation of {@link TimeProvider}
 */
public class AndroidTimeProvider implements TimeProvider {

    @Override
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
