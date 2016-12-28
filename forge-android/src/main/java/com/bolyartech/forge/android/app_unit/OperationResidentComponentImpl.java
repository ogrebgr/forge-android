package com.bolyartech.forge.android.app_unit;

import com.bolyartech.forge.base.misc.ForUnitTestsOnly;

import org.slf4j.LoggerFactory;


/**
 *
 */
public class OperationResidentComponentImpl extends ResidentComponentAdapter
        implements OperationResidentComponent {


    private final org.slf4j.Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private OpState mOpState;

    private OperationResidentComponent.Listener mListener;

    private boolean mIsSuccess;


    /**
     * Default constructor
     *
     * Sets initial state to IDLE
     */
    public OperationResidentComponentImpl() {
        mOpState = OpState.IDLE;
    }


    @Override
    public synchronized OpState getOpState() {
        return mOpState;
    }


    private synchronized void switchToState(OpState opState) {
        if (mOpState != opState) {
            mOpState = opState;
            notifyStateChanged();
        } else {
            mLogger.error("switchToState called but already in state {}", opState);
        }
    }


    @Override
    public boolean isInOpState(OpState opState) {
        return mOpState == opState;
    }


    private synchronized void notifyStateChanged() {
        if (mListener != null) {
            mListener.onResidentOperationStateChanged();
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


    @ForUnitTestsOnly
    public OperationResidentComponent.Listener getListener() {
        return mListener;
    }



    @Override
    public boolean isSuccess() {
        return isEndedSuccessfully();
    }


    @Override
    public boolean isEndedSuccessfully() {
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
    public boolean isBusy() {
        return isInBusyState();
    }


    @Override
    public boolean isInBusyState() {
        return getOpState() == OpState.BUSY;
    }


    @Override
    public synchronized void endedStateAcknowledged() {
        if (getOpState() == OpState.ENDED) {
            switchToState(OpState.IDLE);
        } else {
            mLogger.error("Not in ENDED state when calling endedStateAcknowledged()");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToBusyState() {
        if (getOpState() == OpState.IDLE) {
            mIsSuccess = false;
            switchToState(OpState.BUSY);
        } else {
            throw new IllegalStateException("switchToBusyState() called when not in IDLE state");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToEndedStateSuccess() {
        if (getOpState() == OpState.BUSY) {
            mIsSuccess = true;
            switchToState(OpState.ENDED);
        } else {
            throw new IllegalStateException("switchToEndedStateSuccess() called when not in BUSY state");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void switchToEndedStateFail() {
        if (getOpState() == OpState.BUSY) {
            mIsSuccess = false;
            switchToState(OpState.ENDED);
        } else {
            throw new IllegalStateException("switchToEndedStateFail() called when not in BUSY state");
        }
    }


    @Override
    @SuppressWarnings("unused")
    public synchronized void abort() {
        if (getOpState() == OpState.BUSY) {
            switchToState(OpState.IDLE);
        }
    }


    @Override
    public void ack() {
        endedStateAcknowledged();
    }
}
