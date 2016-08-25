package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


@SuppressWarnings("unused")
abstract public class AbstractIntOperationResidentComponent extends AbstractResidentComponent
        implements IntOperationResidentComponent {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private OpState mOpState;

    private OperationResidentComponent.Listener mListener;

    private Handler mHandler = new Handler();

    private boolean mIsSuccess;
    private int mLastError;


    public AbstractIntOperationResidentComponent() {
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
    public boolean isSuccess() {
        return isCompletedSuccessfully();
    }


    @Override
    public boolean isCompletedSuccessfully() {
        return mIsSuccess;
    }


    @Override
    public int getLastError() {
        return mLastError;
    }


    @SuppressWarnings("unused")
    protected synchronized void switchToBusyState() {
        mLastError = 0;
        mOpState = OpState.BUSY;
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
        mOpState = OpState.COMPLETED;
        notifyStateChanged();
    }


    /**
     * You should normally not call this method but use {@see #completedStateAcknowledged} instead
     */
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
    }


    @Override
    public synchronized void ack() {
        completedStateAcknowledged();
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


    @Override
    public boolean isIdle() {
        return isInIdleState();
    }


    @Override
    public boolean isInIdleState() {
        return mOpState == OpState.IDLE;
    }

}
