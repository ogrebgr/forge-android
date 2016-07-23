package com.bolyartech.forge.android.app_unit.strict_state;

import com.bolyartech.forge.android.app_unit.StateChangedEvent;
import com.bolyartech.forge.android.app_unit.StateManager;
import com.squareup.otto.Bus;


public class StrictStateManagerImpl<T extends Enum<T> & StrictResidentComponentState> implements StateManager<T> {
    private static final StateChangedEvent mStateChangedEvent = new StateChangedEvent();
    private T mState;
    private T mInitialState;
    private final Bus mBus;


    public StrictStateManagerImpl(Bus bus, T initialState) {
        mBus = bus;
        mState = initialState;
        mInitialState = initialState;
    }


    public T getState() {
        return mState;
    }


    public void switchToState(T state) {
        mState = state;
        mBus.post(mStateChangedEvent);
    }


    @Override
    public void reset() {
        mState = mInitialState;
    }
}