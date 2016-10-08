package com.bolyartech.forge.android.app_unit;

import org.slf4j.LoggerFactory;


/**
 * Skeleton implementation for resident component with multiple operations
 * @param <T> enum with operations
 */
abstract public class AbstractMultiOperationResidentComponent<T extends Enum<T>>
        extends AbstractOperationResidentComponent
        implements MultiOperationResidentComponent<T>,
        MultiOperationResidentToActivity<T> {

    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());


    private T mCurrentOperation;

    private boolean mIsSuccess;


    @SuppressWarnings("unused")
    @Override
    public synchronized void switchToBusyState(T operation) {
        mIsSuccess = false;

        mCurrentOperation = operation;
        switchToState(OpState.BUSY);
    }


    @SuppressWarnings("unused")
    @Override
    public synchronized void switchToCompletedStateSuccess() {
        mIsSuccess = true;
        switchToState(OpState.COMPLETED);
    }


    @SuppressWarnings("unused")
    @Override
    public synchronized void switchToCompletedStateFail() {
        mIsSuccess = false;
        switchToState(OpState.COMPLETED);
    }



    @SuppressWarnings("unused")
    @Override
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

        mCurrentOperation = null;
    }


    @Override
    public synchronized void ack() {
        completedStateAcknowledged();
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
        return getOpState() == OpState.IDLE;
    }


    @Override
    public MultiOperationResidentToActivity getResidentToActivity() {
        return this;
    }
}
