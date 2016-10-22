package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.base.misc.ForUnitTestsOnly;


abstract public class AbstractSideEffectOperationResidentComponent<RESULT, ERROR> extends ResidentComponentAdapter implements
        SideEffectOperationResidentComponent<RESULT, ERROR> {

    private final OperationResidentComponentImpl mDelegate = new OperationResidentComponentImpl();

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
    public void endedStateAcknowledged() {
        mDelegate.endedStateAcknowledged();
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
    public synchronized void switchToEndedStateSuccess(RESULT rez) {
        mDelegate.switchToEndedStateSuccess();
        mLastResult = rez;
    }


    @Override
    public synchronized void switchToEndedStateFail(ERROR error) {
        mDelegate.switchToEndedStateFail();
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
