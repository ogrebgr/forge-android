package com.bolyartech.forge.android.app_unit;

import android.app.Activity;
import android.support.annotation.NonNull;


/**
 * Created by ogre on 2015-10-22
 */
abstract public class AbstractResidentComponent implements ResidentComponent {
    private volatile boolean mIsDead = false;
    private ActivityComponent mActivity;


    @Override
    public void onCreate() {
        // empty
    }


    @Override
    public void onActivityResumed(@NonNull ActivityComponent act) {
        mActivity = act;
    }


    @Override
    public void onActivityPaused() {
        // empty
    }


    @Override
    public void onActivityStop() {
        if (mActivity.isFinishing()) {
            die();
        }
        mActivity = null;
    }


    @Override
    public boolean isDead() {
        return mIsDead;
    }


    public final ActivityComponent getActivity() {
        return mActivity;
    }


    @SuppressWarnings("WeakerAccess") // suppressed because subclass my want to die
    protected final void die() {
        mActivity = null;
        mIsDead = true;
    }
}
