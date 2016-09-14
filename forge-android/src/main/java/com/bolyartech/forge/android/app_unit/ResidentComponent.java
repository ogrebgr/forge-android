package com.bolyartech.forge.android.app_unit;


/**
 * Base interface for resident components
 */
public interface ResidentComponent extends ResidentToActivity {
    /**
     * Called after activity is resumed
     * @param activity Activity
     */
    void onActivityResumed(UnitActivity activity);

    /**
     * Called after activity is paused
     */
    void onActivityPaused();


    /**
     * Called after activity is stopped AND it is finishing (i.e. isFinishing() == true)
     */
    @SuppressWarnings("EmptyMethod")
    void onActivityFinishing();
}
