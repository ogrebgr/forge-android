package com.bolyartech.forge.android.app_unit;


/**
 * Created by ogre on 2015-10-22
 */
abstract public class AbstractResidentComponent implements ResidentComponent {
    @Override
    public void onCreate() {
        // empty
    }


    @Override
    public void onActivityResumed(UnitActivity activity) {
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
}
