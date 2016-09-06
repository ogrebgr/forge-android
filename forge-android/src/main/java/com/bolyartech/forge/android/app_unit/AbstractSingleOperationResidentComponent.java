package com.bolyartech.forge.android.app_unit;

import android.os.Handler;
import android.os.Looper;

import org.slf4j.LoggerFactory;


abstract public class AbstractSingleOperationResidentComponent extends AbstractOperationResidentComponent
        implements SingleOperationResidentComponent, ActivityInterface {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private boolean mIsSuccess;


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
        return getOpState() == OpState.IDLE;
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToBusyState() {
        switchToState(OpState.BUSY);
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToCompletedStateSuccess() {
        mIsSuccess = true;
        switchToState(OpState.COMPLETED);
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToCompletedStateFail() {
        mIsSuccess = false;
        switchToState(OpState.COMPLETED);
    }


    /**
     * You should normally not call this method but use {@see #completedStateAcknowledged} instead.
     * This method is intended to be called after aborting given operation in the middle in order to
     * put the resident in IDLE state
     */
    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToIdleState() {
        switchToState(OpState.IDLE);
    }


    @Override
    public synchronized void completedStateAcknowledged() {
        if (getOpState() == OpState.COMPLETED) {
            switchToIdleState();
        } else {
            mLogger.error("Not in COMPLETED state when calling completedStateAcknowledged()");
        }
    }


    @Override
    public synchronized void ack() {
        completedStateAcknowledged();
    }


    @Override
    public OrcActivityInterface getActivityInterface() {
        return this;
    }
}
