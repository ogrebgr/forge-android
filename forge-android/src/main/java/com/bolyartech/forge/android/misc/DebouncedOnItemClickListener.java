package com.bolyartech.forge.android.misc;

import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * Used to replace the regular item click listener in order to provide 'debouncing' functionality, i.e.
 * to prevent 'double clicks' or rapid multiple clicks
 */
abstract public class DebouncedOnItemClickListener implements AdapterView.OnItemClickListener {
    public static long DEFAULT_DEBOUNCE_INTERVAL_MILLIS = 1000;

    private final long minimumInterval;
    private Map<View, Long> lastClickMap;


    /**
     * Implement this in your subclass instead of onClick
     *
     * @param view The view that was clicked
     */
    public abstract void onDebouncedItemClick(AdapterView<?> adapterView, View view, int i, long l);


    /**
     * @param minimumIntervalMillis The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
     */
    public DebouncedOnItemClickListener(long minimumIntervalMillis) {
        this.minimumInterval = minimumIntervalMillis;
        this.lastClickMap = new WeakHashMap<View, Long>();
    }


    public DebouncedOnItemClickListener() {
        this(DEFAULT_DEBOUNCE_INTERVAL_MILLIS);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Long previousClickTimestamp = lastClickMap.get(view);
        long currentTimestamp = SystemClock.uptimeMillis();

        lastClickMap.put(view, currentTimestamp);
        if (previousClickTimestamp == null || (currentTimestamp - previousClickTimestamp > minimumInterval)) {
            onDebouncedItemClick(adapterView, view, i, l);
        }
    }
}
