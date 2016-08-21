package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


@SuppressWarnings("unused")
abstract public class AbstractSimpleOperationResidentComponent extends AbstractResidentComponent implements SimpleOperationResidentComponent {
    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private OperationState mState;

    private OperationResidentComponent.Listener mListener;

    private Handler mHandler = new Handler();

    private boolean mIsSuccess;
    private int mLastError;


    public AbstractSimpleOperationResidentComponent() {
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
    public boolean isSuccess() {
        return mIsSuccess;
    }


    @Override
    public int getLastError() {
        return mLastError;
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToBusyState() {
        mLastError = 0;
        mState = OperationState.BUSY;
        notifyStateChanged();
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToCompletedStateSuccess() {
        mIsSuccess = true;
        completed();
    }


    protected synchronized void switchToCompletedStateFail() {
        mIsSuccess = false;
        mLastError = 0;
        completed();
    }


    protected synchronized void switchToCompletedStateFail(int error) {
        mIsSuccess = false;
        mLastError = error;
        completed();
    }


    private void completed() {
        mState = OperationState.COMPLETED;
        notifyStateChanged();
    }


    /**
     * You should normally not call this method but use {@see #completedStateAcknowledged} instead
     */
    @SuppressWarnings("unused")
    protected synchronized void switchToIdleState() {
        mState = OperationState.IDLE;
        notifyStateChanged();
    }


    @Override
    public synchronized void completedStateAcknowledged() {
        if (mState == OperationState.COMPLETED) {
            mState = OperationState.IDLE;
        } else {
            mLogger.error("Not in COMPLETED state when calling completedStateAcknowledged()");
        }
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
