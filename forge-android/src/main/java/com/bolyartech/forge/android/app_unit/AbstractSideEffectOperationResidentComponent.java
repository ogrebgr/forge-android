package com.bolyartech.forge.android.app_unit;

import org.slf4j.LoggerFactory;


/**
 * Skeleton implementations for resident component with single operation with side effect
 * @param <RESULT>
 * @param <ERROR>
 */
@SuppressWarnings("unused")
abstract public class AbstractSideEffectOperationResidentComponent<RESULT, ERROR>
        extends AbstractOperationResidentComponent
        implements SideEffectOperationResidentComponent<RESULT, ERROR> {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private boolean mIsSuccess;
    private ERROR mLastError;
    private RESULT mLastResult;


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


    @Override
    public void switchToBusyState() {
        mLastResult = null;
        switchToState(OpState.BUSY);
    }


    @Override
    public synchronized void switchToCompletedStateSuccess(RESULT rez) {
        mIsSuccess = true;
        mLastResult = rez;
        completed();
    }


    @Override
    public synchronized void switchToCompletedStateFail(ERROR error) {
        mIsSuccess = false;
        mLastError = error;
        completed();
    }


    private void completed() {
        switchToState(OpState.COMPLETED);
    }


    /**
     * You should normally not call this method but use {@see #completedStateAcknowledged} instead
     */
    @SuppressWarnings("unused")
    @Override
    public synchronized void switchToIdleState() {
        switchToState(OpState.IDLE);
    }


    @Override
    public synchronized void completedStateAcknowledged() {
        if (getOpState() == OpState.COMPLETED) {
            switchToState(OpState.IDLE);
        } else {
            mLogger.error("Not in COMPLETED state when calling completedStateAcknowledged()");
        }
    }


    @Override
    public synchronized void ack() {
        completedStateAcknowledged();
    }


    @Override
    public boolean isIdle() {
        return isInIdleState();
    }


    @Override
    public boolean isInIdleState() {
        return getOpState() == OpState.IDLE;
    }


    public RESULT getLastResult() {
        return mLastResult;
    }
}

