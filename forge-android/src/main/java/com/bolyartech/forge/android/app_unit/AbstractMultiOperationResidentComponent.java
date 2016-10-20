package com.bolyartech.forge.android.app_unit;

import com.bolyartech.forge.base.misc.ForUnitTestsOnly;

import org.slf4j.LoggerFactory;


public class AbstractMultiOperationResidentComponent<T extends Enum<T>> extends ResidentComponentAdapter
        implements MultiOperationResidentComponent<T> {

    private AbstractOperationResidentComponent mDelegate = new AbstractOperationResidentComponent();
    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

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


    @ForUnitTestsOnly
    public OperationResidentComponent.Listener getListener() {
        return mDelegate.getListener();
    }


    @Override
    public boolean isSuccess() {
        return mDelegate.isSuccess();
    }


    @Override
    public boolean isCompletedSuccessfully() {
        return mDelegate.isCompletedSuccessfully();
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
    public synchronized void completedStateAcknowledged() {
        mDelegate.completedStateAcknowledged();
        mCurrentOperation = null;
    }


    @Override
    public void switchToCompletedStateSuccess() {
        mDelegate.switchToCompletedStateSuccess();
    }


    @Override
    public void switchToCompletedStateFail() {
        mDelegate.switchToCompletedStateFail();
    }


    @Override
    public void abort() {
        mDelegate.abort();
    }


    @Override
    public void ack() {
        completedStateAcknowledged();
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
}
