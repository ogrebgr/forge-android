package com.bolyartech.forge.android.app_unit;


/**
 * Created by ogre on 2015-10-22
 */
public interface ResidentComponent {
    void onCreate();

    void onActivityResumed();

    @SuppressWarnings("EmptyMethod")
    void onActivityPaused();

    void onActivityFinishing();

    boolean isDead();
}
