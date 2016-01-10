package com.bolyartech.forge.app_unit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;


/**
 * Created by ogre on 2016-01-10 11:45
 */
abstract public class UnitApplication extends Application {
    @Inject
    UnitManager mUnitManager;


    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }


            @Override
            public void onActivityStarted(Activity activity) {
            }


            @Override
            public void onActivityResumed(Activity activity) {
                if (activity instanceof ActivityComponent) {
                    ActivityComponent comp = (ActivityComponent) activity;
                    comp.setResidentComponent(mUnitManager.onActivityResumed(comp));
                }
            }


            @Override
            public void onActivityPaused(Activity activity) {
                if (activity instanceof ActivityComponent) {
                    mUnitManager.onActivityPaused((ActivityComponent) activity);
                }
            }


            @Override
            public void onActivityStopped(Activity activity) {
                if (activity instanceof ActivityComponent) {
                    mUnitManager.onActivityStopped((ActivityComponent) activity);
                }
            }


            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }


            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
