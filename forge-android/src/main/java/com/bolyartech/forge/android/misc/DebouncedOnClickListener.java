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
    public static long DEFAULT_DEBOUNCE_INTERVAL_MILLIS = 1000;
    private final long minimumInterval;
    private Map<View, Long> lastClickMap;


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
        this.minimumInterval = minimumIntervalMillis;
        this.lastClickMap = new WeakHashMap<View, Long>();
    }


    public DebouncedOnClickListener() {
        this(DEFAULT_DEBOUNCE_INTERVAL_MILLIS);
    }


    @Override
    public void onClick(View clickedView) {
        Long previousClickTimestamp = lastClickMap.get(clickedView);
        long currentTimestamp = SystemClock.uptimeMillis();

        lastClickMap.put(clickedView, currentTimestamp);
        if (previousClickTimestamp == null || (currentTimestamp - previousClickTimestamp > minimumInterval)) {
            onDebouncedClick(clickedView);
        }
    }
}