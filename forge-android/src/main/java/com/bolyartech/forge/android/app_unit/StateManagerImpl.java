package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.android.misc.EventPoster;


public class StateManagerImpl<T extends Enum<T>> implements StateManager<T> {
    private static final StateChangedEvent mStateChangedEvent = new StateChangedEvent();
    private T mState;
    private T mDefaultState;
    private final EventPoster mPoster;


    public StateManagerImpl(EventPoster poster, T initialState) {
        mPoster = poster;
        mState = initialState;
        mDefaultState = initialState;
    }


    public T getState() {
        return mState;
    }


    public void switchToState(T state) {
        mState = state;
        mPoster.postEvent(mStateChangedEvent);
    }


    @Override
    public void reset() {
        mState = mDefaultState;
    }
}
