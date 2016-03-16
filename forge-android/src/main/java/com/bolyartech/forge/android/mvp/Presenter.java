package com.bolyartech.forge.android.mvp;

import android.os.Bundle;

import com.bolyartech.forge.android.app_unit.ActivityResultContainer;


/**
 * Created by ogre on 2015-10-26
 */
public interface Presenter {
    void onCreate();
    void onResume(ActivityResultContainer container);
    void onPause();
    void onDestroy();
}
