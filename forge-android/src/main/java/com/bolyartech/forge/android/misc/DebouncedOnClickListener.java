package com.bolyartech.forge.android.misc;

import android.os.SystemClock;
import android.view.View;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * Used to replace the regular click listener in order to provide 'debouncing' functionality, i.e.
 * to prevent 'double clicks' or rapid multiple clicks
 */
public abstract class DebouncedOnClickListener implements View.OnClickListener {
    public static final long DEFAULT_DEBOUNCE_INTERVAL_MILLIS = 1000;
    private final long mMinimumInterval;
    private final Map<View, Long> mLastClickMap;


    /**
     * Implement this in your subclass instead of onClick
     *
     * @param v The view that was clicked
     */
    public abstract void onDebouncedClick(View v);


    /**
     * @param minimumIntervalMillis The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
     */
    public DebouncedOnClickListener(long minimumIntervalMillis) {
        this.mMinimumInterval = minimumIntervalMillis;
        this.mLastClickMap = new WeakHashMap<>();
    }


    public DebouncedOnClickListener() {
        this(DEFAULT_DEBOUNCE_INTERVAL_MILLIS);
    }


    @Override
    public void onClick(View clickedView) {
        Long previousClickTimestamp = mLastClickMap.get(clickedView);
        long currentTimestamp = SystemClock.uptimeMillis();

        mLastClickMap.put(clickedView, currentTimestamp);
        if (previousClickTimestamp == null || (currentTimestamp - previousClickTimestamp > mMinimumInterval)) {
            onDebouncedClick(clickedView);
        }
    }
}