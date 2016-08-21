package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;


abstract public class AbstractMultiOperationResidentComponent<T extends Enum<T>>
        extends AbstractResidentComponent implements MultiOperationResidentComponent<T> {

    private OperationState mState;

    private T mCurrentOperation;

    private OperationResidentComponent.Listener mListener;

    private Handler mHandler = new Handler();


    public AbstractMultiOperationResidentComponent() {
        mState = OperationState.IDLE;
    }


    @Override
    public synchronized OperationState getOperationState() {
        return mState;
    }


    @Override
    public boolean isInOperationState(OperationState state) {
        return mState == state;
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


    @SuppressWarnings("unused")
    protected synchronized void switchToBusyState(T operation) {
        mState = OperationState.BUSY;
        mCurrentOperation = operation;
        notifyStateChanged();
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToCompletedState() {
        mState = OperationState.COMPLETED;
        notifyStateChanged();
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToIdleState() {
        mState = OperationState.IDLE;
        notifyStateChanged();
    }


    @Override
    public synchronized void completedStateAcknowledged() {
        mState = OperationState.IDLE;
        mCurrentOperation = null;
    }


    private void notifyStateChanged() {
        if (mListener != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                mHandler.post(() -> mListener.onResidentOperationStateChanged());
            } else {
                mListener.onResidentOperationStateChanged();
            }
        }
    }


    @Override
    public T getCurrentOperation() {
        return mCurrentOperation;
    }
}
