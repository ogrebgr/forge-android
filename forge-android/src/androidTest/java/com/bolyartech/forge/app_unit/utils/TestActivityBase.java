package com.bolyartech.forge.app_unit.utils;

import android.app.Activity;

import com.bolyartech.forge.app_unit.ActivityComponent;


/**
 * Created by ogre on 2016-01-01 09:47
 */
abstract public class TestActivityBase extends Activity implements ActivityComponent {
    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
