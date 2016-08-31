package com.bolyartech.forge.android.app_unit;


/**
 * Base interface for resident components
 */
public interface ResidentComponent {
    void onActivityResumed(UnitActivity activity);

    @SuppressWarnings("EmptyMethod")
    void onActivityPaused();

    @SuppressWarnings("EmptyMethod")
    void onActivityFinishing();
}
