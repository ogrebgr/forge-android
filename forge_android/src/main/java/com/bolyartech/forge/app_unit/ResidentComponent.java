package com.bolyartech.forge.app_unit;

import android.support.annotation.NonNull;


/**
 * Created by ogre on 2015-10-22
 */
public interface ResidentComponent {
    void onCreate();

    void onActivityResumed(@NonNull ActivityComponent act);

    void onActivityPaused();

    void onActivityFinishing();

    boolean isDead();
}
