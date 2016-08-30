package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import com.bolyartech.forge.base.misc.TimeProvider;

import org.slf4j.LoggerFactory;

import javax.inject.Inject;


/**
 * Created by ogre on 2016-01-10 11:45
 */
abstract public class UnitApplication extends Application {
    // how long after last activity is paused the onInterfacePaused() method will be called
    private final long INTERFACE_PAUSED_TIMEOUT = 10_000;

    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Inject
    UnitManager mUnitManager;

    @Inject
    TimeProvider mTimeProvider;


    private final Handler mHandler = new Handler();

    private boolean mHasResumedActivity = false;
    private long mLastPausedTs;
    private boolean mInterfacePaused = false;

    private final Runnable mPausedCheckRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mHasResumedActivity) {
                if (mLastPausedTs + INTERFACE_PAUSED_TIMEOUT < mTimeProvider.getTime()) {
                    mInterfacePaused = true;
                    onInterfacePaused();
                }
            }
        }
    };


    protected void onInterfacePaused() {
        mLogger.debug("onInterfacePaused()");
    }


    protected void onInterfaceResumed() {
        mLogger.debug("onInterfaceResumed()");
    }


    @Override
    public void onCreate() {
        super.onCreate();


        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (activity instanceof UnitActivity) {
                    UnitActivity act = (UnitActivity) activity;
                    mUnitManager.onActivityCreated(act);
                }
            }


            @Override
            public void onActivityStarted(Activity activity) {
            }


            @Override
            public void onActivityResumed(Activity activity) {
                mHandler.removeCallbacks(mPausedCheckRunnable);
                mHasResumedActivity = true;

                if (mInterfacePaused) {
                    mInterfacePaused = false;
                    onInterfaceResumed();
                }

                mLogger.trace("Activity resumed: {}", activity);

                if (activity instanceof UnitActivity) {
                    UnitActivity act = (UnitActivity) activity;
                    mUnitManager.onActivityResumed(act);
                }
            }


            @Override
            public void onActivityPaused(Activity activity) {
                mHasResumedActivity = false;

                mHandler.postDelayed(mPausedCheckRunnable,
                        INTERFACE_PAUSED_TIMEOUT);

                mLogger.trace("Activity paused: {}", activity);
                if (activity instanceof UnitActivity) {
                    mUnitManager.onActivityPaused((UnitActivity) activity);
                }
            }


            @Override
            public void onActivityStopped(Activity activity) {
                if (activity instanceof UnitActivity) {
                    mUnitManager.onActivityStopped((UnitActivity) activity);
                }
            }


            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }


            @Override
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof UnitActivity) {
                    mUnitManager.onActivityDestroyed((UnitActivity) activity);
                }
            }
        });
    }


    @SuppressWarnings("unused")
    protected void setUnitManager(UnitManager unitManager) {
        mUnitManager = unitManager;
    }
}
