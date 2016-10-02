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
    /**
     * Default debounce interval in milliseconds
     */
    public static final long DEFAULT_DEBOUNCE_INTERVAL_MILLIS = 1000;

    private final long mMinimumInterval;
    private final Map<View, Long> mLastClickMap;


    /**
     * Implement this in your subclass instead of onClick
     * @param adapterView  The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    public abstract void onDebouncedItemClick(AdapterView<?> adapterView, View view,  int position, long id);


    /**
     * @param minimumIntervalMillis The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
     */
    @SuppressWarnings({"unused"})
    public DebouncedOnItemClickListener(long minimumIntervalMillis) {
        this.mMinimumInterval = minimumIntervalMillis;
        this.mLastClickMap = new WeakHashMap<>();
    }


    /**
     * Creates DebouncedOnItemClickListener with default debounce interval DEFAULT_DEBOUNCE_INTERVAL_MILLIS
     */
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
