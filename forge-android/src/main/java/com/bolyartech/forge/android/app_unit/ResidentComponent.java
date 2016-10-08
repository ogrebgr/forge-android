package com.bolyartech.forge.android.app_unit;


/**
 * Base interface for resident components
 */
public interface ResidentComponent {
    /**
     * Called by the UnitManager after activity is resumed (i.e. after the call to <code>super.onResume()</code>)
     * <b>Application developers must not call this method directly</b>
     * @param activity Activity
     */
    void onActivityResumed(UnitActivity activity);

    /**
     * Called by the UnitManager after activity is paused (i.e. after the call to <code>super.onPause()</code>);
     * <b>Application developers must not call this method directly</b>
     */
    void onActivityPaused();


    /**
     * Called after activity is stopped AND it is finishing (i.e. isFinishing() == true)
     * <b>Application developers must not call this method directly</b>
     */
    void onActivityFinishing();
}
