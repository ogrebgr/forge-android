package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.support.annotation.NonNull;


/**
 * Created by ogre on 2015-10-22
 */
abstract public class AbstractResidentComponent implements ResidentComponent {
    private volatile boolean mIsDead = false;


    @Override
    public void onCreate() {
        // empty
    }


    @Override
    public void onActivityResumed() {
        // empty
    }


    @Override
    public void onActivityPaused() {
        // empty
    }


    @Override
    public void onActivityFinishing() {
        // empty
    }


    @Override
    public boolean isDead() {
        return mIsDead;
    }


    @SuppressWarnings("WeakerAccess") // suppressed because subclass may want to die
    protected final void die() {
        mIsDead = true;
    }
}
