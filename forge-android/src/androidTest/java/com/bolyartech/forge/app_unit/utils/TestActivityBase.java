package com.bolyartech.forge.app_unit.utils;

import android.app.Activity;

import com.bolyartech.forge.app_unit.ActivityComponent;
import com.bolyartech.forge.app_unit.ResidentComponent;


/**
 * Created by ogre on 2016-01-01 09:47
 */
abstract public class TestActivityBase extends Activity implements ActivityComponent {
    private ResidentComponent mResidentComponent;

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


    @Override
    public void setResidentComponent(ResidentComponent res) {
        mResidentComponent = res;
    }


    @Override
    public ResidentComponent getResidentComponent() {
        return mResidentComponent;
    }
}
