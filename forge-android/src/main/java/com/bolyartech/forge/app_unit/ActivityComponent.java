package com.bolyartech.forge.app_unit;

/**
 * Created by ogre on 2015-10-26
 */
public interface ActivityComponent {
    void onResume();

    void onPause();

    void onStop();

    ResidentComponent createResidentComponent();
}
