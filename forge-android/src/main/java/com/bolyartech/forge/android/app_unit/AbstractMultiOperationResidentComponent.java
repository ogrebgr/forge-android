package com.bolyartech.forge.android.app_unit;

import com.bolyartech.forge.base.misc.ForUnitTestsOnly;


/**
 * Skeleton implementation for resident component with multiple operations
 *
 * @param <T> enum with operations
 */
abstract public class AbstractMultiOperationResidentComponent<T extends Enum<T>> extends ResidentComponentAdapter
        implements MultiOperationResidentComponent<T> {

    private final OperationResidentComponentImpl mDelegate = new OperationResidentComponentImpl();

    private T mCurrentOperation;


    @Override
    public OperationResidentComponent.OpState getOpState() {
        return mDelegate.getOpState();
    }


    @Override
    public boolean isInOpState(OperationResidentComponent.OpState opState) {
        return mDelegate.isInOpState(opState);
    }


    @Override
    public void onActivityResumed(UnitActivity activity) {
        mDelegate.onActivityResumed(activity);
    }


    @Override
    public void onActivityPaused() {
        mDelegate.onActivityPaused();
    }


    /**
     * Gets the listener
     *
     * @return listener
     */
    @ForUnitTestsOnly
    public OperationResidentComponent.Listener getListener() {
        return mDelegate.getListener();
    }


    @Override
    public boolean isSuccess() {
        return mDelegate.isSuccess();
    }


    @Override
    public boolean isEndedSuccessfully() {
        return mDelegate.isEndedSuccessfully();
    }


    @Override
    public boolean isIdle() {
        return mDelegate.isIdle();
    }


    @Override
    public boolean isInIdleState() {
        return mDelegate.isInIdleState();
    }


    @Override
    public synchronized void endedStateAcknowledged() {
        mDelegate.endedStateAcknowledged();
        mCurrentOperation = null;
    }


    @Override
    public void switchToEndedStateSuccess() {
        mDelegate.switchToEndedStateSuccess();
    }


    @Override
    public void switchToEndedStateFail() {
        mDelegate.switchToEndedStateFail();
    }


    @Override
    public void abort() {
        mDelegate.abort();
    }


    @Override
    public void ack() {
        endedStateAcknowledged();
    }


    @Override
    public synchronized void switchToBusyState(T operation) {
        mCurrentOperation = operation;
        mDelegate.switchToBusyState();
    }


    @Override
    public synchronized T getCurrentOperation() {
        return mCurrentOperation;
    }


    @Override
    public boolean isBusy() {
        return isInBusyState();
    }


    @Override
    public boolean isInBusyState() {
        return getOpState() == OperationResidentComponent.OpState.BUSY;
    }

}
