package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;


abstract public class AbstractStatefulResidentComponent<T extends Enum<T>>
        extends AbstractResidentComponent implements StatefulResidentComponent<T> {

    private T mState;
    private T mInitialState;

    private UnitActivity mActivity;

    private Handler mHandler = new Handler();


    public AbstractStatefulResidentComponent(T initialState) {
        mInitialState = initialState;
        mState = initialState;
    }


    @Override
    public T getState() {
        return mState;
    }


    @Override
    public boolean isInState(T state) {
        return mState == state;
    }


    @SafeVarargs
    @Override
    public final boolean isInOneOfStates(T state, T... states) {
        if (mState == state) {
            return true;
        }

        if (states.length > 0) {
            for (T st : states) {
                if (mState == st) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    @Override
    public synchronized void onActivityResumed(UnitActivity activity) {
        super.onActivityResumed(activity);
        mActivity = activity;
    }


    @Override
    public synchronized void onActivityPaused() {
        super.onActivityPaused();
        mActivity = null;
    }


    protected synchronized void switchToState(T state) {
        mState = state;
        if (mActivity != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mActivity.stateChanged();
                    }
                });
            } else {
                mActivity.stateChanged();
            }
        }
    }


    protected void resetState() {
        mState = mInitialState;
    }
}
