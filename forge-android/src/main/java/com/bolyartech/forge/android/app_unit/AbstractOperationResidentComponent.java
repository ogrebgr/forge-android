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


    private synchronized  void notifyStateChanged() {
        if (mListener != null) {
             mListener.onResidentOperationStateChanged();
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
