package com.bolyartech.forge.android.app_unit;

public interface StateManager<T extends Enum<T> & ResidentComponentState> {
    T getState();
    void switchToState(T state);
    void reset();
}
