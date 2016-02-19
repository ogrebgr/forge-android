package com.bolyartech.forge.android.app_unit;


import com.bolyartech.forge.android.misc.AndroidEventPoster;


public class StateManagerImpl<T extends Enum<T>> implements StateManager<T> {
    private static final StateChangedEvent mStateChangedEvent = new StateChangedEvent();
    private T mState;
    private final AndroidEventPoster mPoster;


    public StateManagerImpl(AndroidEventPoster poster, T initialState) {
        mPoster = poster;
        mState = initialState;
    }


    public T getState() {
        return mState;
    }


    public void switchToState(T state) {
        mState = state;
        mPoster.postEvent(mStateChangedEvent);
    }
}
