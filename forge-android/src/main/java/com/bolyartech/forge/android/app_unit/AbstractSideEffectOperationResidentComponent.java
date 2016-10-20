package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.base.misc.ForUnitTestsOnly;

import org.slf4j.LoggerFactory;


public class AbstractSideEffectOperationResidentComponent<RESULT, ERROR> extends ResidentComponentAdapter implements
        SideEffectOperationResidentComponent<RESULT, ERROR> {

    private AbstractOperationResidentComponent mDelegate = new AbstractOperationResidentComponent();
    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private ERROR mLastError;
    private RESULT mLastResult;



    @Override
    public void abort() {
        mDelegate.abort();
    }


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
    public void completedStateAcknowledged() {
        mDelegate.completedStateAcknowledged();
    }


    @Override
    public void switchToBusyState() {
        mDelegate.switchToBusyState();
    }


    @Override
    public void ack() {
        mDelegate.ack();
    }


    @Override
    public synchronized void switchToCompletedStateSuccess(RESULT rez) {
        mDelegate.switchToCompletedStateSuccess();
        mLastResult = rez;
    }


    @Override
    public synchronized void switchToCompletedStateFail(ERROR error) {
        mDelegate.switchToCompletedStateFail();
        mLastError = error;
    }


    public synchronized RESULT getLastResult() {
        return mLastResult;
    }


    @Override
    public synchronized ERROR getLastError() {
        return mLastError;
    }
}
