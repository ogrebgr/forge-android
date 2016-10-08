package com.bolyartech.forge.android.app_unit;

import org.slf4j.LoggerFactory;


/**
 * Skeleton implementation for single operation resident component
 */
@SuppressWarnings("unused")
abstract public class AbstractSingleOperationResidentComponent extends AbstractOperationResidentComponent
        implements SingleOperationResidentComponent {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

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
        if (getOpState() == OpState.IDLE) {
            switchToState(OpState.BUSY);
        } else {
            throw new IllegalStateException("switchToBusyState() called when not in IDLE state");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToCompletedStateSuccess() {
        if (getOpState() == OpState.BUSY) {
            mIsSuccess = true;
            switchToState(OpState.COMPLETED);
        } else {
            throw new IllegalStateException("switchToCompletedStateSuccess() called when not in BUSY state");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToCompletedStateFail() {
        if (getOpState() == OpState.BUSY) {
            mIsSuccess = false;
            switchToState(OpState.COMPLETED);
        } else {
            throw new IllegalStateException("switchToCompletedStateFail() called when not in BUSY state");
        }
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
    public OperationResidentToActivity getResidentToActivity() {
        return this;
    }
}
