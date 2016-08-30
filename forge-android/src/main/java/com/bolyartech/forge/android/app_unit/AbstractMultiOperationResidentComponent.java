package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


abstract public class AbstractMultiOperationResidentComponent<T extends Enum<T>>
        extends AbstractResidentComponent implements MultiOperationResidentComponent<T> {

    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());


    private OpState mOpState;

    private T mCurrentOperation;

    private OperationResidentComponent.Listener mListener;

    private final Handler mHandler = new Handler();

    private boolean mIsSuccess;


    public AbstractMultiOperationResidentComponent() {
        mOpState = OpState.IDLE;
    }


    @Override
    public synchronized OpState getOpState() {
        return mOpState;
    }


    @Override
    public boolean isInOpState(OpState opState) {
        return mOpState == opState;
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
        mIsSuccess = false;
        mOpState = OpState.BUSY;
        mCurrentOperation = operation;
        notifyStateChanged();
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToCompletedStateSuccess() {
        mIsSuccess = true;
        mOpState = OpState.COMPLETED;
        notifyStateChanged();
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToCompletedStateFail() {
        mIsSuccess = false;
        mOpState = OpState.COMPLETED;
        notifyStateChanged();
    }



    @SuppressWarnings("unused")
    protected synchronized void switchToIdleState() {
        mOpState = OpState.IDLE;
        notifyStateChanged();
    }


    @Override
    public synchronized void completedStateAcknowledged() {
        if (mOpState == OpState.COMPLETED) {
            mOpState = OpState.IDLE;
        } else {
            mLogger.error("Not in COMPLETED state when calling completedStateAcknowledged()");
        }

        mCurrentOperation = null;
    }


    @Override
    public synchronized void ack() {
        completedStateAcknowledged();
    }


    private void notifyStateChanged() {
        if (mListener != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                mHandler.post(() -> {
                    synchronized (AbstractMultiOperationResidentComponent.this) {
                        if (mListener != null) {
                            mListener.onResidentOperationStateChanged();
                        }
                    }
                });
            } else {
                mListener.onResidentOperationStateChanged();
            }
        }
    }


    @Override
    public T getCurrentOperation() {
        return mCurrentOperation;
    }


    @Override
    public boolean isSuccess() {
        return isCompletedSuccessfully();
    }


    @Override
    public boolean isCompletedSuccessfully() {
        return mIsSuccess;
    }

    @Override
    public boolean isIdle() {
        return isInIdleState();
    }


    @Override
    public boolean isInIdleState() {
        return mOpState == OpState.IDLE;
    }

}
