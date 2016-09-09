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
@SuppressWarnings("WeakerAccess")
abstract public class DebouncedOnItemClickListener implements AdapterView.OnItemClickListener {
    public static final long DEFAULT_DEBOUNCE_INTERVAL_MILLIS = 1000;

    private final long mMinimumInterval;
    private final Map<View, Long> mLastClickMap;


    /**
     * Implement this in your subclass instead of onClick
     *
     * @param view The view that was clicked
     */
    public abstract void onDebouncedItemClick(AdapterView<?> adapterView, View view, int i, long l);


    /**
     * @param minimumIntervalMillis The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
     */
    @SuppressWarnings({"SameParameterValue", "unused"})
    public DebouncedOnItemClickListener(long minimumIntervalMillis) {
        this.mMinimumInterval = minimumIntervalMillis;
        this.mLastClickMap = new WeakHashMap<>();
    }


    @SuppressWarnings("unused")
    public DebouncedOnItemClickListener() {
        this(DEFAULT_DEBOUNCE_INTERVAL_MILLIS);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Long previousClickTimestamp = mLastClickMap.get(view);
        long currentTimestamp = SystemClock.uptimeMillis();

        mLastClickMap.put(view, currentTimestamp);
        if (previousClickTimestamp == null || (currentTimestamp - previousClickTimestamp > mMinimumInterval)) {
            onDebouncedItemClick(adapterView, view, i, l);
        }
    }
}
