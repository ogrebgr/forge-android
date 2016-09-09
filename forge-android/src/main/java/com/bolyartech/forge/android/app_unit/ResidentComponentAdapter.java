package com.bolyartech.forge.android.app_unit;


/**
 * Provides empty implementation of the methods of ResidentComponent
 */
abstract public class ResidentComponentAdapter implements ResidentComponent {
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
