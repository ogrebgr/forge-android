package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


/**
 * Skeleton implementation for operation component
 *
 * Initial state is set to IDLE
 */
@SuppressWarnings("WeakerAccess")
abstract public class AbstractOperationResidentComponent extends ResidentComponentAdapter
        implements OperationResidentComponent {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private OpState mOpState;

    private OperationResidentComponent.Listener mListener;

    private final Handler mHandler = new Handler();


    /**
     * Default constructor
     *
     * Sets initial state to IDLE
     */
    public AbstractOperationResidentComponent() {
        mOpState = OpState.IDLE;
    }


    @Override
    public synchronized OpState getOpState() {
        return mOpState;
    }


    @Override
    public synchronized void switchToState(OpState opState) {
        if (mOpState != opState) {
            mOpState = opState;
            notifyStateChanged();
        } else {
            mLogger.error("switchToState called but already in state {}", opState);
        }
    }


    @Override
    public boolean isInOpState(OpState opState) {
        return mOpState == opState;
    }


    private void notifyStateChanged() {
        if (mListener != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (AbstractOperationResidentComponent.this) {
                            if (mListener != null) {
                                mListener.onResidentOperationStateChanged();
                            }
                        }
                    }
                });
            } else {
                mListener.onResidentOperationStateChanged();
            }
        }
    }


    @Override
    public synchronized void onActivityResumed(UnitActivity activity) {
        super.onActivityResumed(activity);
        if (activity instanceof OperationResidentComponent.Listener) {
            mListener = (OperationResidentComponent.Listener) activity;
        }
    }


    @Override
    public synchronized void onActivityPaused() {
        super.onActivityPaused();
        mListener = null;
    }
}
