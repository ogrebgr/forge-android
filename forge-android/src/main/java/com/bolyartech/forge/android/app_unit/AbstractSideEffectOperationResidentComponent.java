package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


@SuppressWarnings("unused")
abstract public class AbstractSideEffectOperationResidentComponent<RESULT, ERROR> extends AbstractResidentComponent
        implements SideEffectOperationResidentComponent<RESULT, ERROR> {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private OpState mOpState;

    private OperationResidentComponent.Listener mListener;

    private final Handler mHandler = new Handler();

    private boolean mIsSuccess;
    private ERROR mLastError;
    private RESULT mLastResult;


    public AbstractSideEffectOperationResidentComponent() {
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
    public ERROR getLastError() {
        return mLastError;
    }


    protected synchronized void switchToBusyState() {
        mLastError = null;
        mOpState = OpState.BUSY;
        notifyStateChanged();
    }


    protected synchronized void switchToCompletedStateSuccess() {
        mIsSuccess = true;
        mLastResult = null;
        completed();
    }


    protected synchronized void switchToCompletedStateSuccess(RESULT rez) {
        mIsSuccess = true;
        mLastResult = rez;
        completed();
    }


    protected synchronized void switchToCompletedStateFail() {
        mIsSuccess = false;
        mLastError = null;
        completed();
    }


    protected synchronized void switchToCompletedStateFail(ERROR error) {
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


    public RESULT getLastResult() {
        return mLastResult;
    }
}
