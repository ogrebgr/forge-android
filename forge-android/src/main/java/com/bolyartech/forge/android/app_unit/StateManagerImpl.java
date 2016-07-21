package com.bolyartech.forge.android.app_unit;


import com.squareup.otto.Bus;


public class StateManagerImpl<T extends Enum<T>> implements StateManager<T> {
    private static final StateChangedEvent mStateChangedEvent = new StateChangedEvent();
    private T mState;
    private T mInitialState;
    private final Bus mBus;


    public StateManagerImpl(Bus bus, T initialState) {
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
