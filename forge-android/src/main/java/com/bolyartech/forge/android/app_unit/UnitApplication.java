package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import com.bolyartech.forge.base.misc.ForUnitTestsOnly;
import com.bolyartech.forge.base.misc.TimeProvider;

import org.slf4j.LoggerFactory;

import javax.inject.Inject;


/**
 * Application that uses {@link UnitManager} to manage Forge units
 *
 * Uses ActivityLifecycleCallbacks to notify the UnitManager for activity's lifecycle events
 */
abstract public class UnitApplication extends Application {
    // how long after last activity is paused the onInterfacePaused() method will be called
    private final long INTERFACE_PAUSED_TIMEOUT = 10_000;

    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

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
                if (mLastPausedTs + INTERFACE_PAUSED_TIMEOUT < mTimeProvider.getVmTime()) {
                    mInterfacePaused = true;
                    onInterfacePaused();
                }
            }
        }
    };


    /**
     * Called when all activities are paused.
     * <p>
     * Use this method to 'shutdown' global TaskExecutors or other objects that need to free used resources.
     * <p>
     * If you have other application components aside activities like services or broadcast receivers that use those
     * global objects you will have to take in account that they (may) need those objects too so you will have to
     * manually take care for such cases and shutdown the global objects only when the services and broadcast receivers
     * are finished.
     * <p>
     * Please note that this method is not called immediately after all activities are paused
     * but after {@link #INTERFACE_PAUSED_TIMEOUT} expires. This is so because when new activity is starting on top
     * of the old one, the old one is paused and there is a small 'gap' in time before new activity is created and
     * resumed. Default value for INTERFACE_PAUSED_TIMEOUT is 10 seconds.
     */
    protected void onInterfacePaused() {
        mLogger.debug("onInterfacePaused()");
    }


    /**
     * Called <b>only</b> when there is a resumed activity AFTER the interface have been paused (i.e. onInterfacePaused() was
     * called some time in the past).
     */
    protected void onInterfaceResumed() {
        mLogger.debug("onInterfaceResumed()");
    }


    @Override
    public void onCreate() {
        super.onCreate();


        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                mLogger.trace("activity created: {}", activity);
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

                mLogger.trace("activity resumed: {}", activity);

                if (activity instanceof UnitActivity) {
                    UnitActivity act = (UnitActivity) activity;
                    mUnitManager.onActivityResumed(act);
                }
            }


            @Override
            public void onActivityPaused(Activity activity) {
                mHasResumedActivity = false;
                mLastPausedTs = mTimeProvider.getVmTime();

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


    /**
     * Use this method to set the unit manager if you don't use dependency injection (like Dagger 2 for example)
     * You will have to create {@link UnitManagerImpl} in {@link #onCreate()} and call this method.
     * @param unitManager UnitManager implementation, usually {@link UnitManagerImpl}
     */
    @SuppressWarnings("unused")
    protected void setUnitManager(UnitManager unitManager) {
        mUnitManager = unitManager;
    }
}
