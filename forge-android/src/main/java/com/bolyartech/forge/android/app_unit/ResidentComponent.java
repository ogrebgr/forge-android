package com.bolyartech.forge.android.app_unit;


/**
 * Created by ogre on 2015-10-22
 */
public interface ResidentComponent {
    void onCreate();

    void onActivityResumed(UnitActivity activity);

    @SuppressWarnings("EmptyMethod")
    void onActivityPaused();

    @SuppressWarnings("EmptyMethod")
    void onActivityFinishing();
}
